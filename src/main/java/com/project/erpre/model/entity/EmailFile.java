package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "m_email_file")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmailFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_attachment_nm")
    private Integer emailAttachmentNm;

    @Column(name = "email_file_name", nullable = false)
    private String emailFileName;

    @Column(name = "email_file_url", nullable = false)
    private String emailFileUrl;

    @ManyToOne(fetch = FetchType.LAZY) // (지연로딩)
    @JoinColumn(name = "email_nm", nullable = false)
    private Email emailNm;

}
