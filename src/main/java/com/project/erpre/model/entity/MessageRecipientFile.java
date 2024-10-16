package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "m_message_recipient_file")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageRecipientFile {

    @EmbeddedId
    private MessageRecipientFileId messageRecipientFileId;

    @ManyToOne
    @MapsId("messageRecipientId")
    @JoinColumns({
            @JoinColumn(name = "message_no", nullable = false),
            @JoinColumn(name = "recipient_id", nullable = false)
    })
    private MessageRecipient messageRecipient;

    @ManyToOne
    @MapsId("messageAttachmentId")
    @JoinColumn(name = "message_attachment_id", nullable = false)
    private MessageFile messageFile;

    @Column(name = "message_recipient_file_delete_yn", nullable = false, length = 10)
    private String deleteYn;

}
