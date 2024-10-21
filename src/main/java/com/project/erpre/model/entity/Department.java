package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "m_department")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name", length = 50, nullable = false)
    private String departmentName;

    @Column(name = "department_location", length = 100)
    private String departmentLocation;

    @Column(name = "department_tel", length = 20)
    private String departmentTel;

    @Column(name = "department_insert_date", nullable = false, updatable = false)
    private LocalDateTime departmentInsertDate;  // 기본값 설정

    @Column(name = "department_update_date")
    private LocalDateTime departmentUpdateDate;

    @Column(name = "department_delete_yn", length = 1, nullable = false, columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String departmentDeleteYn;  // 기본값 설정

    @Column(name = "department_delete_date")
    private LocalDateTime departmentDeleteDate;

    // 부서에 속한 여러 직원들과의 관계
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    @ToString.Exclude
    private List<Employee> employees;
}
