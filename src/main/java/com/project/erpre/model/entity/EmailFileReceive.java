package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "m_email_file_receive")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmailFileReceive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_file_nm_r")
    private Integer emailFileNmR;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_nm_r", nullable = false)
    private EmailReceive emailNmR;  // 수신 이메일 외래 키

    @Column(name = "email_file_name_r", nullable = false)
    private String emailFileNameR;

    @Column(name = "email_file_url_r", nullable = false)
    private String emailFileUrlR;

    @Column(name = "email_file_size_r")
    private Long emailFileSizeR;

    @Column(name = "email_file_type_r")
    private String emailFileTypeR;

    @Column(name = "email_file_del_yn_r", nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'n'")
    private String emailFileDelYnR;

    @Column(name = "email_file_del_date_r")
    private Timestamp emailFileDelDateR;
}
