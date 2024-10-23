package com.project.erpre.controller;

import com.project.erpre.model.dto.EmployeeDTO;
import com.project.erpre.service.EmployeeService;
import com.project.erpre.service.MessengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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


}
