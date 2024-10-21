package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 출고 엔티티
 */
@Entity
@Table(name = "m_dispatch")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dispatch_no")
    private Integer dispatchNo; // 출고 번호

    @Column(name = "dispatch_status", length = 100, nullable = true, columnDefinition = "VARCHAR(100) DEFAULT 'pending'")
    private String dispatchStatus; // 출고 상태

    @Column(name = "dispatch_start_date", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp dispatchStartDate; // 출고 시작일시

    @Column(name = "dispatch_end_date")
    private Timestamp dispatchEndDate; // 출고 완료일시

    @Column(name = "dispatch_qr_code", length = 500)
    private String dispatchQrCode; // 출고 QR 코드

    @Column(name = "dispatch_delete_yn", length = 1, nullable = true, columnDefinition = "CHAR(1) DEFAULT 'n'")
    private String dispatchDeleteYn; // 출고 삭제 여부

    // 고객
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_no", nullable = false)
    private Customer customer;

    // 주문
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_h_no")
    private Order orderheader;

    // 주문 상세
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_d_no")
    private OrderDetail orderdetail;

    // 창고
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_no", nullable = false)
    private Warehouse warehouse;

    // 본사
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hq_name", referencedColumnName = "hq_name", nullable = false)
    private Hq hq;

}
