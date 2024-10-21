package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name =  "m_email_send")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmailSend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_nm_s")
    private Integer emailNmS;

    // 직원 테이블 외래키 참조
    @Column(name = "email_id_s", nullable = false)
    private String emailIdS;  // 발신 직원 ID

    @Column(name = "email_addr_receive_s", nullable = false)
    private String emailAddrReceiveS;  // 수신 직원 이메일

    @Column(name = "email_subject_s", nullable = false)
    private String emailSubjectS;

    @Column(name = "email_content_s", nullable = false)
    private String emailContentS;

    @Column(name = "email_date_s", nullable = false, insertable = false, updatable = false)
    private Timestamp emailDateS;

    @Column(name = "email_status_s", nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'nr'")
    private String emailStatusS = "nr";

    // 첨부파일 리스트
    @OneToMany(mappedBy = "emailNmS", cascade = CascadeType.ALL)
    private List<EmailFileSend> sentEmailFiles;  // 발신 이메일의 첨부파일 리스트


}
