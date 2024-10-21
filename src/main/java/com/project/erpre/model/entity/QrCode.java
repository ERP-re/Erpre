package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "qr_code_id", columnDefinition = "uuid")
    private UUID qrCodeId; // QR 코드 ID

    @Column(name = "qr_code_data", length = 300, nullable = false)
    private String qrCodeData; // QR 코드 데이터

    @Column(name = "qr_code_status", length = 20, nullable = false)
    private String qrCodeStatus; // QR 코드 상태

    @Column(name = "qr_code_created")
    private Timestamp qrCodeCreated; // QR 코드 생성 일시

    @Column(name = "qr_code_insert_date", insertable = false, updatable = false)
    private Timestamp qrCodeInsertDate; // QR 코드 등록 일시

    @Column(name = "qr_code_expiration_date")
    private Timestamp qrCodeExpirationDate; // QR 코드 만료 일시

    @Column(name = "qr_code_last_scanned")
    private Timestamp qrCodeLastScanned; // QR 코드 마지막 스캔 일시

    @Column(name = "qr_code_usage_count", nullable = false, columnDefinition = "integer default 0")
    private Integer qrCodeUsageCount; // QR 코드 사용 횟수

    @Column(name = "qr_code_delete_yn", length = 1, nullable = false, columnDefinition = "char(1) default 'n'")
    private String qrCodeDeleteYn; // QR 코드 삭제 여부

    @Column(name = "qr_code_delete_date")
    private Timestamp qrCodeDeleteDate; // QR 코드 삭제 일시

    // 직원과의 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Employee employee; // 직원

    // 창고와의 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_no", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Warehouse warehouse; // 창고

    // 주문 상세와의 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_d_no", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private OrderDetail orderDetail; // 주문 상세

}
