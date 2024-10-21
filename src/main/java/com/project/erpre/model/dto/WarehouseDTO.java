package com.project.erpre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseDTO {

    private Integer warehouseNo; // 창고 번호
    private String warehouseName; // 창고명
    private String warehouseTel; // 창고 대표 전화번호
    private String warehouseAddr; // 창고 주소
    private String warehouseManagerName; // 창고 담당자 이름

}
