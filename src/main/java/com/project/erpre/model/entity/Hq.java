package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "m_hq")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hq {

    @Id
    @Column(name = "hq_name", length = 20)
    private String hqName; // 본사 이름

    @Column(name = "hq_tel", length = 30)
    private String hqTel; // 본사 전화번호

    @Column(name = "hq_representative_name", length = 30)
    private String hqRepresentativeName; // 본사 대표 이름

    @Column(name = "hq_business_reg_no", length = 50, nullable = false)
    private String hqBusinessRegNo; // 본사 사업자 등록번호

    @Column(name = "hq_addr", length = 200)
    private String hqAddr; // 본사 주소

    //출고 리스트 (본사와 연관된 출고들)
    @ToString.Exclude
    @OneToMany(mappedBy = "hq", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Dispatch> dispatches; // 출고 목록

}
