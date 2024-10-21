package com.project.erpre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QrCodeDTO {

    private UUID qrCodeId; // QR 코드 ID
    private String qrCodeData; // QR 코드 데이터
    private String qrCodeStatus; // QR 코드 상태
    private Timestamp qrCodeCreated; // QR 코드 생성 일시
    private Timestamp qrCodeInsertDate; // QR 코드 등록 일시
    private Timestamp qrCodeExpirationDate; // QR 코드 만료 일시
    private Timestamp qrCodeLastScanned; // QR 코드 마지막 스캔 일시
    private Integer qrCodeUsageCount; // QR 코드 사용 횟수
    private String qrCodeDeleteYn; // QR 코드 삭제 여부
    private Timestamp qrCodeDeleteDate; // QR 코드 삭제 일시
    private String employeeId; // 직원 ID
    private Integer warehouseNo; // 창고 번호
    private Integer orderDNo; // 주문 상세 번호

}
