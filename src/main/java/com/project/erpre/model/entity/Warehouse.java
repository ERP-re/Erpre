package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "m_warehouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_no")
    private Integer warehouseNo; // 창고 번호

    @Column(name = "warehouse_name", length = 100, nullable = false)
    private String warehouseName; // 창고 이름

    @Column(name = "warehouse_tel", length = 20)
    private String warehouseTel; // 창고 전화번호

    @Column(name = "warehouse_representative_name", length = 50)
    private String warehouseRepresentativeName; // 창고 대표자 이름

    @Column(name = "warehouse_business_reg_no", length = 20, nullable = false)
    private String warehouseBusinessRegNo; // 창고 사업자 등록번호

    @Column(name = "warehouse_addr", length = 200)
    private String warehouseAddr; // 창고 주소

    @Column(name = "warehouse_insert_date", insertable = false, updatable = false)
    private Timestamp warehouseInsertDate; // 창고 등록일시

    // 주문 상세와의 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_d_no", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private OrderDetail orderDetail; // 주문 상세

    // 고객과의 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_no", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Customer customer; // 고객

}
