package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "m_chat_message_read_file")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChatMessageReadFile {

    @EmbeddedId
    private ChatMessageReadFileId chatMessageReadFileId;

    @ToString.Exclude
    @MapsId("chatMessageReadId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "chat_message_no", referencedColumnName = "chat_message_no", nullable = false),
            @JoinColumn(name = "chat_message_recipient_id", referencedColumnName = "chat_message_recipient_id", nullable = false)
    })
    private ChatMessageRead chatMessageRead;

    @MapsId("chatAttachmentId")
    @ManyToOne
    @JoinColumn(name = "chat_attachment_id", referencedColumnName = "chat_attachment_id", nullable = false)
    private ChatFile chatFile;

    @Column(name = "chat_message_read_file_delete_yn", nullable = false, length = 10)
    private String deleteYn;

}
