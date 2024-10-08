package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "m_chat_message_read")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChatMessageRead {

    @EmbeddedId
    private ChatMessageReadId id;

    @ManyToOne
    @MapsId("chatMessageNo")
    @JoinColumn(name = "chat_message_no", nullable = false)
    private ChatMessage chatMessage;

    @ManyToOne
    @MapsId("chatMessageRecipientId")
    @JoinColumn(name = "chat_message_recipient_id", nullable = false)
    private Employee employee;

    @Column(nullable = false, length = 10)
    private String chatMessageReadYn = "n";

    private LocalDateTime chatMessageReadDate;

}
