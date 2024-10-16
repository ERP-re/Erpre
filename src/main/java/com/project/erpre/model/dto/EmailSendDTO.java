package com.project.erpre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailSendDTO {

    private Integer emailNmS;
    private String employeeIdS;  // 발신 직원 ID
    private String emailAddrReceiveS;  // 수신 직원 이메일
    private String emailSubjectS;
    private String emailContentS;
    private Timestamp emailSendDateS;
    private String emailStatusS;  // 이메일 상태 (nr, r, nd, d) 기본값 'nr'

    private List<EmailFileSendDTO> sentEmailFiles;

}
