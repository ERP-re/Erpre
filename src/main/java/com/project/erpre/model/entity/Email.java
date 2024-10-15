package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name =  "m_email")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_nm")
    private Integer emailNm;

    // 직원 테이블 외래키 참조
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employeeId;

    @Column(name = "email_addr_get", nullable = false)
    private String emailAddrGet;

    @Column(name = "email_subject", nullable = false)
    private String emailSubject;

    @Column(name = "email_content", nullable = false)
    private String emailContent;

    @Column(name = "email_send_date", nullable = false, insertable = false, updatable = false)
    private Timestamp emailSendDate;

    @Column(name = "email_status", nullable = false, columnDefinition = "VARCHAR(2) DEFAULT 'nr'")
    private String emailStatus = "nr";

    // 첨부파일 리스트
    @OneToMany(mappedBy= "email", cascade = CascadeType.ALL, orphanRemoval = true) // 이메일 삭제 시 첨부파일 삭제
    private List<EmailFile> emailFile;


}
