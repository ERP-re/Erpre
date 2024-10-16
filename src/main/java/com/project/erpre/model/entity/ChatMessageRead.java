package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    @JoinColumn(name = "chat_message_no", referencedColumnName = "chat_message_no", nullable = false)
    private ChatMessage chatMessage;

    @ManyToOne
    @MapsId("chatMessageRecipientId")
    @JoinColumn(name = "chat_message_recipient_id", referencedColumnName = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false, length = 10)
    private String chatMessageReadYn = "n";

    @Column(nullable = false, length=10)
    private String chatMessageDeleteYn = "n";

    private LocalDateTime chatMessageDeleteDate;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "chatMessageRead", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatMessageReadFile> ChatMessageReadFiles;
}
