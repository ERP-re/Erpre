package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.Id;


import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "m_message_file")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_attachment_id")
    private Integer messageAttachmentId;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "message_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private Message message;

    @Column(name = "message_file_name", length = 255)
    private String messageFileName;

    @Column(name = "message_file_url", nullable = false, length = 255)
    private String messageFileUrl;

    @Column(name = "message_file_size")
    private BigInteger messageFileSize;

    @Column(name = "message_file_type", length = 50)
    private String messageFileType;

}
