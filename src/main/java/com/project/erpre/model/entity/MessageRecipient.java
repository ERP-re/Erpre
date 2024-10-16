package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "m_message_recipient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageRecipient {

    @EmbeddedId
    private MessageRecipientId messageRecipientId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("messageNo")
    @JoinColumn(name = "message_no", nullable = false)
    private Message message;

    @ToString.Exclude
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

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "messageRecipient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageRecipientFile> messageRecipientFiles;

}

