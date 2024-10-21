package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name =  "m_email_receive")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmailReceive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_nm_r")
    private Integer emailNmR;

    @Column(name = "email_id_r", nullable = false)
    private String emailIdR;  // 수신 직원 ID

    @Column(name = "email_addr_send_r", nullable = false)
    private String emailAddrSendR;  // 발신 직원 이메일

    @Column(name = "email_subject_r", nullable = false)
    private String emailSubjectR;

    @Column(name = "email_content_r", nullable = false)
    private String emailContentR;

    @Column(name = "email_date_r", nullable = false, insertable = false, updatable = false)
    private Timestamp emailDateR;

    @Column(name = "email_status_r", nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'nr'")
    private String emailStatusR;

    @OneToMany(mappedBy = "emailNmR", cascade = CascadeType.ALL)
    private List<EmailFileReceive> receivedEmailFiles;  // 수신 이메일의 첨부파일 리스트
}
