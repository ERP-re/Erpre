package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "m_email_file_send")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmailFileSend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_file_nm_s")
    private Integer emailFileNmS;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_nm_s", nullable = false)
    private EmailSend emailNmS;  // 발신 이메일 외래 키

    @Column(name = "email_file_name_s", nullable = false)
    private String emailFileNameS;

    @Column(name = "email_file_url_s", nullable = false)
    private String emailFileUrlS;

    @Column(name = "email_file_size_s")
    private Long emailFileSizeS;

    @Column(name = "email_file_type_s")
    private String emailFileTypeS;

    @Column(name = "email_file_del_yn_s", nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'n'")
    private String emailFileDelYnS = "n";

    @Column(name = "email_file_del_date_s")
    private Timestamp emailFileDelDateS;
}
