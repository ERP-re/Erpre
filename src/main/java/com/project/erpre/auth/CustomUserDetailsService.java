package com.project.erpre.auth;

import com.project.erpre.model.entity.Employee;
import com.project.erpre.model.entity.Job;
import com.project.erpre.repository.EmployeeRepository;
import com.project.erpre.repository.JobRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Spring Security 인증처리
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;


    public CustomUserDetailsService(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String employeeId) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new UsernameNotFoundException("직원ID를 찾을 수 없습니다" + employeeId));

        Job job = employee.getJob();

        if (job == null) {
            throw new UsernameNotFoundException("직원의 역할을 찾을 수 없습니다: " + employee.getEmployeeId());
        }

        String role = job.getJobRole();

        return User.builder()
                .username(employee.getEmployeeId()) // employeeId를 username으로 사용
                .password(employee.getEmployeePw()) // employeePw를 password로 사용
                .roles(role) // job 테이블에서 가져온 role을 role로 사용
                .build();
    }

}
