package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "m_salary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private Integer salaryId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)  // 직원 외래키
    private Employee employee;

    @Column(name = "base_salary", nullable = false)
    private Integer baseSalary;

    @Column(name = "bonus", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer bonus;

    @Column(name = "performance_incentive_rate", precision = 5, scale = 2, nullable = false, columnDefinition = "DECIMAL(5,2) DEFAULT 0.00")
    private BigDecimal performanceIncentiveRate;

    @Column(name = "total_salary", nullable = false)
    private Integer totalSalary;

    @Column(name = "salary_date", nullable = false)
    private LocalDate salaryDate;

    @Column(name = "salary_status", length = 20, nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'Pending'")
    private String salaryStatus;

    @Column(name = "salary_insert_date", nullable = false, updatable = false)
    private LocalDateTime salaryInsertDate;

    @Column(name = "salary_update_date")
    private LocalDateTime salaryUpdateDate;
}
