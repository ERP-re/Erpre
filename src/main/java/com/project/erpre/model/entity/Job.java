package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "m_job")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "job_name", length = 50, nullable = false)
    private String jobName;

    @Column(name = "min_years_of_service", nullable = false)
    private Integer minYearsOfService;

    @Column(name = "min_salary", nullable = false)
    private Integer minSalary;

    @Column(name = "grade_incentive_rate", precision = 5, scale = 2, nullable = false)
    private BigDecimal gradeIncentiveRate;

    @Column(name = "job_role", length = 20, nullable = false)
    private String jobRole;

    @Column(name = "job_insert_date", nullable = false, updatable = false)
    private LocalDateTime jobInsertDate;  // 기본값 설정

    @Column(name = "job_update_date")
    private LocalDateTime jobUpdateDate;

    @Column(name = "job_delete_yn", length = 1, nullable = false, columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String jobDeleteYn;  // 기본값 설정

    @Column(name = "job_delete_date")
    private LocalDateTime jobDeleteDate;

    @OneToMany(mappedBy = "job")
    @JsonIgnore
    @ToString.Exclude
    private List<Employee> employees;
}
