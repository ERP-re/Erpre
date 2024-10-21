package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "m_qr_code")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class QrCode {

    @Id
    @Column(name = "qr_code_id")
    private UUID qrCodeId; // QR 코드 ID

    @Column(name = "qr_code_data", length = 300, nullable = false)
    private String qrCodeData; // QR 코드 데이터

    @Column(name = "qr_code_status", length = 20, nullable = true, columnDefinition = "VARCHAR(20) DEFAULT 'active'")
    private String qrCodeStatus; // QR 코드 상태

    @Column(name = "qr_code_insert_date", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp qrCodeInsertDate; // QR 코드 생성 일시

    @Column(name = "qr_code_expiration_date")
    private Timestamp qrCodeExpirationDate; // QR 코드 만료 일시

    @Column(name = "qr_code_last_scanned")
    private Timestamp qrCodeLastScanned; // QR 코드 마지막 스캔 일시

    @Column(name = "qr_code_usage_count", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer qrCodeUsageCount; // QR 코드 사용 횟수

    @Column(name = "qr_code_delete_yn", length = 1, nullable = false, columnDefinition = "CHAR(1) DEFAULT 'n'")
    private String qrCodeDeleteYn; // QR 코드 삭제 여부

    @Column(name = "qr_code_delete_date")
    private Timestamp qrCodeDeleteDate; // QR 코드 삭제 일시

    // 직원
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    //출고창고
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_no")
    private Warehouse warehouse;

    //주문 상세
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_d_no")
    private OrderDetail orderdetail;

}
