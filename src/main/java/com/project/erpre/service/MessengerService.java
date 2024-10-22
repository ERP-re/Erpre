package com.project.erpre.service;

import com.project.erpre.model.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.project.erpre.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessengerService {

    private static final Logger logger = LoggerFactory.getLogger(MessengerService.class);

    private final EmployeeRepository employeeRepository;

    @Autowired
    public MessengerService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getEmployeesWithDept() {
        logger.info("메신저에서 직원 조회");
        return employeeRepository.getEmployeesWithDept();
    }

}
