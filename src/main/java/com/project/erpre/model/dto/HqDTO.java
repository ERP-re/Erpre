package com.project.erpre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HqDTO {

    private String hqName; // 본사 이름
    private String hqTel; // 본사 전화번호
    private String hqRepresentativeName; // 본사 대표 이름
    private String hqBusinessRegNo; // 본사 사업자 등록번호
    private String hqAddr; // 본사 주소

}
