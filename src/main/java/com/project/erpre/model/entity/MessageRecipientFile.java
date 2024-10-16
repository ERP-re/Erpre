package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "m_message_recipient_file")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageRecipientFile {

    @EmbeddedId
    private MessageRecipientFileId id;

    @ManyToOne
    @MapsId("messageNo")
    @JoinColumn(name = "message_no", nullable = false)
    private MessageRecipient messageNo;

    @ManyToOne
    @MapsId("recipientId")
    @JoinColumn(name = "recipient_id", nullable = false)
    private Employee recipientId;

    @ManyToOne
    @MapsId("messageAttachmentId")
    @JoinColumn(name = "message_attachment_id", nullable = false)
    private MessageFile messageFile;

    @Column(name = "message_recipient_file_delete_yn", nullable = false, length = 10)
    private String deleteYn;

    @Column(name = "message_recipient_file_delete_date")
    private LocalDateTime deleteDate;
}
