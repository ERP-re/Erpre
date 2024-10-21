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
public class EmailReceiveDTO {

    private Integer emailNmR;
    private String emailIdR;  // 수신 직원 ID
    private String emailAddrSendR;  // 발신 직원 이메일
    private String emailSubjectR;
    private String emailContentR;
    private Timestamp emailDateR;
    private String emailStatusR;  // 이메일 상태 (nr, r, nd, d) 기본값 'nr'

    private List<EmailFileReceiveDTO> receivedEmailFiles;  // 수신 첨부파일 리스트
}
