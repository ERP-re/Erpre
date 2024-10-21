package com.project.erpre.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// 인증 (로그인 요청을 처리하고 로그인 성공시 JWT 토큰을 발급)
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // 로그인 요청 처리
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            LoginRequest loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmployeeId(), loginRequest.getEmployeePw());

            return authenticationManager.authenticate(authenticationToken);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    // 로그인 성공시 JWT 토큰 발급 및 쿠키 저장
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {

        String username = authResult.getName();

        // 사용자 권한 정보
        List<String> roles = authResult.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        // JWT 토큰 생성
        String token = jwtTokenProvider.generateToken(username, roles);

        // httpOnly 쿠키에 JWT 저장
        Cookie jwtCookie = new Cookie("jwt", token);
        jwtCookie.setHttpOnly(true); // JavaScript로 접근 불가능
        jwtCookie.setSecure(false); // HTTPS에만 전송 (SSL을 사용할 때 필수, !!!개발환경에서는 false)
        jwtCookie.setPath("/"); // 쿠키 유효 경로
        jwtCookie.setMaxAge(60 * 60); // 쿠키 만료 시간 (1시간)

        // 응답에 쿠키 추가
        response.addCookie(jwtCookie);

        // 응답 본문으로 JWT 정보 전달 (선택 사항)
        Date issuedAt = jwtTokenProvider.getIssuedAtFromToken(token);
        Date expiration = jwtTokenProvider.getExpirationFromToken(token);
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(
                new JwtResponse(token, issuedAt, expiration)
        ));

    }

    // 로그인 실패 시 처리
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("로그인 실패: " + failed.getMessage());
    }


}
