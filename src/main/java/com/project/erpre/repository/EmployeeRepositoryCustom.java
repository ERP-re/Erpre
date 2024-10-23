package com.project.erpre.repository;

import com.project.erpre.model.dto.EmployeeDTO;
import com.project.erpre.model.entity.Employee;
import com.querydsl.core.Tuple;

import java.util.List;

public interface EmployeeRepositoryCustom {

    // 1. 메신저 직원 조회 (조직도)
    List<Employee> getEmployeesWithDept();

    // 2. 현재 로그인한 직원 조회
    Employee getLoginEmployee(String employeeId);
}
