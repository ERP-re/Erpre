package com.project.erpre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDTO {
    private Integer emailNm;
    private String employeeId;
    private String emailAddrGet;
    private String emailSubject;
    private String emailContent;
    private Timestamp emailSendDate;
    private String emailStatus;  // 이메일 상태 (nr, r, nd, d) 기본값 'nr'

    private ArrayList<EmailFileDTO> emailFile;

}
