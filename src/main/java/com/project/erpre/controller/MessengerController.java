package com.project.erpre.controller;

import com.project.erpre.model.dto.ChatDTO;
import com.project.erpre.model.dto.EmployeeDTO;
import com.project.erpre.service.EmployeeService;
import com.project.erpre.service.MessengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messengers")
public class MessengerController {

    private static final Logger logger = LoggerFactory.getLogger(MessengerController.class);

    private final MessengerService messengerService;
    private final EmployeeService employeeService;

    @Autowired
    public MessengerController(MessengerService messengerService, EmployeeService employeeService) {
        this.messengerService = messengerService;
        this.employeeService = employeeService;
    }

    // 1. 메신저 직원 조회 (조직도)
    @GetMapping("/employeeList")
    public List<EmployeeDTO> getEmployeesWithDept() {
        return employeeService.getEmployeesWithDept();
    }

    // 2. 현재 참여하고 있는 채팅 목록 조회 및 검색
    @GetMapping("/chatList")
    public List<ChatDTO> getChatListByUser(String searchKeyword) {

        // SecurityContext에서 현재 인증된 사용자 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("인증된 사용자를 찾을 수 없습니다. 로그인이 필요합니다.");
        }

        // UserDetails로 변환하여 ID 가져오기
        Object principal = authentication.getPrincipal();
        String employeeId;

        if (principal instanceof User) {
            employeeId = ((User) principal).getUsername();
        } else {
            employeeId = principal.toString();
        }

        // 검색 키워드와 함께 채팅 목록 조회
        return messengerService.getChatListByUser(employeeId, searchKeyword);
    }


}
