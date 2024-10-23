package com.project.erpre.auth;

import com.project.erpre.model.entity.Employee;
import com.project.erpre.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;

@Controller
public class AuthController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session, HttpServletResponse response) {
        try {
            System.out.println("로그인 시도 ID:" + loginRequest.getEmployeeId());

            // 로그인 요청 처리
            Employee employee = employeeRepository.findByEmployeeId(loginRequest.getEmployeeId())
                    .orElseThrow(() -> {
                        System.out.println("해당 ID를 찾을 수 없습니다: " + loginRequest.getEmployeeId());
                        return new RuntimeException("해당 ID를 찾을 수 없습니다");
                    });

            // 직원 정보 확인
            System.out.println("조회 직원: " + employee.toString());

            // 비밀번호 일치 여부 확인
            if (!loginRequest.getEmployeePw().equals(employee.getEmployeePw())) {
                System.out.println("비밀번호가 일치하지 않습니다: " + loginRequest.getEmployeeId());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Collections.singletonMap("message", "비밀번호가 일치하지 않습니다."));
            }

            // 비밀번호 확인
            System.out.println("비밀번호 확인: " + loginRequest.getEmployeeId());


            // 로그인 성공 시 세션에 사용자 정보 저장
            session.setAttribute("employee", employee);

            // HTTP-only 쿠키 설정 (세션ID를 쿠키에 설정)
            Cookie sessionCookie = new Cookie("SESSION", session.getId());
            sessionCookie.setHttpOnly(true); // JavaScript에서 쿠키에 접근하지 못하도록 설정
            sessionCookie.setSecure(false); // HTTPS에서만 사용 (개발 중에는 false로 설정)
            sessionCookie.setPath("/"); // 쿠키 유효 경로 설정
            sessionCookie.setMaxAge(60 * 60); // 쿠키 만료 시간 설정 (1시간)

            // 응답에 쿠키 추가
            response.addCookie(sessionCookie);

            // 로그인 성공
            System.out.println("로그인 성공: " + loginRequest.getEmployeeId());

            // 로그인 성공시 응답으로 성공 메시지를 반환
            return ResponseEntity.ok(Collections.singletonMap("message", "로그인 성공"));
        } catch (RuntimeException e) {
            // 특정 예외 처리
            System.out.println("런타임 예외 발생: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", e.getMessage()));
        } catch (Exception e) {
            // 일반 예외 처리
            System.out.println("예외 발생: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("message", "로그인 처리 중 오류가 발생했습니다."));
        }
    }
}
