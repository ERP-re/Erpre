package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "m_chat_message")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="chat_message_no")
    private Long chatMessageNo;

    @ManyToOne
    @JoinColumn(name = "chat_no", nullable = false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "chat_sender_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private String chatMessageContent;

    @Column(nullable = false)
    private LocalDateTime chatSendDate;

    @Column(nullable = false, length = 10)
    private String chatMessageDeleteYn = "n";

    private LocalDateTime chatMessageDeleteDate;

    @OneToMany(mappedBy = "chatMessage")
    @JsonIgnore
    @ToString.Exclude
    private List<ChatMessageRead> chatMessageReads;

    @OneToMany(mappedBy = "chatMessage")
    @JsonIgnore
    @ToString.Exclude
    private List<ChatFile> chatFiles;

}
