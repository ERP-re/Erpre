package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "m_message_recipient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageRecipient {

    @EmbeddedId
    private MessageRecipientId messageRecipientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("messageNo")
    @JoinColumn(name = "message_no", nullable = false)
    private Message message;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("recipientId")
    @JoinColumn(name = "recipient_id", nullable = false)
    private Employee employee;

    @Column(nullable = false, length = 10)
    private String recipientReadYn = "n";

    private LocalDateTime recipientReadDate;

    @Column(nullable = false, length = 10)
    private String recipientDeleteYn = "n";

    private LocalDateTime recipientDeleteDate;
}

