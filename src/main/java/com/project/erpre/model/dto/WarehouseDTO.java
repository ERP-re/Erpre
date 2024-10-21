package com.project.erpre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseDTO {

    private Integer warehouseNo; // 창고 번호
    private String warehouseName; // 창고 이름
    private String warehouseTel; // 창고 전화번호
    private String warehouseRepresentativeName; // 창고 대표자 이름
    private String warehouseBusinessRegNo; // 창고 사업자 등록번호
    private String warehouseAddr; // 창고 주소
    private Timestamp warehouseInsertDate; // 창고 등록일시
    private Integer orderDNo; // 주문 상세 번호
    private Integer customerNo; // 고객 번호

}
