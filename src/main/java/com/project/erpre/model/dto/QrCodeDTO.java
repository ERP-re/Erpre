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
    private Timestamp qrCodeInsertDate; // QR 코드 생성 일시
    private Timestamp qrCodeExpirationDate; // QR 코드 만료 일시
    private Timestamp qrCodeLastScanned; // QR 코드 마지막 스캔 일시
    private Integer qrCodeUsageCount; // QR 코드 사용 횟수
    private String qrCodeDeleteYn; // QR 코드 삭제 여부
    private Timestamp qrCodeDeleteDate; // QR 코드 삭제 일시
    private String employeeId; // QR코드 생성자
    private Integer warehouseNo; // QR코드 출고  창고 이름
    private Integer orderDNo; // QR코드 상품 상세

    //Entity : 데이터베이스 테이블과 1:1로 매핑되며, JPA 어노테이션을 사용해 연관 관계(@ManyToOne, @OneToMany 등)를 설정하고 데이터베이스에서 가져온 데이터를 관리합니다.
    //DTO : 서비스 계층과 컨트롤러 사이에서 데이터를 간결하게 전송하기 위한 객체로, 필요에 따라 연관 객체 대신 ID와 같은 단순 필드만 포함하여 전송 효율을 높입니다.

}
