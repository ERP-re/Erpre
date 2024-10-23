package com.project.erpre.repository;

import com.project.erpre.model.dto.EmployeeDTO;
import com.project.erpre.model.entity.Employee;
import com.project.erpre.model.entity.QDepartment;
import com.project.erpre.model.entity.QEmployee;
import com.project.erpre.model.entity.QJob;
import com.querydsl.core.Tuple;
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

    // 1. 메신저 직원 조회 (조직도)
    @Override
    public List<Employee> getEmployeesWithDept() {
        QEmployee employee = QEmployee.employee;
        QDepartment department = QDepartment.department;
        QJob job = QJob.job;

        return queryFactory
                .selectFrom(employee)
                .leftJoin(employee.department, department).fetchJoin()  // Department 조인
                .leftJoin(employee.job, job).fetchJoin()
                .fetch();
    }

    // 2. 현재 로그인한 직원 조회
    @Override
    public Employee getLoginEmployee(String employeeId) {
        QEmployee employee = QEmployee.employee;
        QDepartment department = QDepartment.department;
        QJob job = QJob.job;

        return queryFactory
                .selectFrom(employee)
                .leftJoin(employee.department, department).fetchJoin()
                .leftJoin(employee.job, job).fetchJoin()
                .where(employee.employeeId.eq(employeeId))
                .fetchOne();

    }
}

