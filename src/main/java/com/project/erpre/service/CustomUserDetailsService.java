package com.project.erpre.service;

import com.project.erpre.model.entity.Employee;
import com.project.erpre.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String employeeId) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmployeeId(employeeId)
            .orElseThrow(() -> new UsernameNotFoundException("직원ID를 찾을 수 없습니다" + employeeId));

        return User.builder()
                .username(employee.getEmployeeId()) // employeeId를 username으로 사용
                .password(employee.getEmployeePw()) // employeePw를 password로 사용
                .roles(employee.getEmployeeRole()) // employeeRole을 Role로 사용
                .build();
    }

}
