package com.project.erpre.config;

import com.project.erpre.auth.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public WebSecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    // 회원가입이 생략되어 평문 비밀번호를 사용하고 있으므로 BCryptPasswordEncoder 제거
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:8787")); // 정확하게 일치하는 주소 사용
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // 모든 HTTP 메서드 명시적 허용
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type")); // 필요한 헤더 추가
        configuration.setAllowCredentials(true); // 쿠키 허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().configurationSource(corsConfigurationSource()) // CORS 설정 활성화 및 직접 설정
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // 세션 기반으로 설정
                .and()
                .authorizeRequests()
                    .antMatchers("/",  "/static/**", "/bundle/**", "/img/**", "/css/**", "/fonts/**", "/index.html").permitAll()
                    .antMatchers("/api/login", "/login", "/**").permitAll() // 로그인 앤드포인트 허용 (현재 모든 페이지 접근 허용! 이거 나중에 바꿔야 함)
                    .antMatchers("/user/**").hasAnyRole("Staff", "Admin", "Assistant Manager", "Executive", "Director", "Manager")
                    .antMatchers("/admin/**").hasRole("Admin")
                    .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
                .and()
//                .formLogin() // 기본 로그인 폼 제공
//                    .loginPage("/api/login")
//                    .defaultSuccessUrl("/main", true)
//                    .permitAll()
//                .and()
                .logout() // 로그아웃 처리
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .permitAll();

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }
}

