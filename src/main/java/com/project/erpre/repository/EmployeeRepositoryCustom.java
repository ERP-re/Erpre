package com.project.erpre.repository;

import com.project.erpre.model.dto.EmployeeDTO;
import com.project.erpre.model.entity.Employee;

import java.util.List;

public interface EmployeeRepositoryCustom {

    // 1. 메신저 직원 조회 (부서, 이름)
    List<EmployeeDTO> getEmployeesWithDept();

}
