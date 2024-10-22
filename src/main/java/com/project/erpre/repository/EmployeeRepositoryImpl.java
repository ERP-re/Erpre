package com.project.erpre.repository;

import com.project.erpre.model.dto.EmployeeDTO;
import com.project.erpre.model.entity.QDepartment;
import com.project.erpre.model.entity.QEmployee;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);

    private final JPAQueryFactory queryFactory;

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    // 1. 메신저 직원 조회 (부서, 이름)
    @Override
    public List<EmployeeDTO> getEmployeesWithDept() {
        QEmployee employee = QEmployee.employee;
        QDepartment department = QDepartment.department;

        return queryFactory
                .select(Projections.constructor(EmployeeDTO.class,
                        employee.employeeId,
                        employee.employeeName,
                        employee.employeeStatus,
                        employee.employeeStatusMessage,
                        department.departmentName))
                .from(employee)
                .leftJoin(employee.department, department)
                .fetch();
    }
}
