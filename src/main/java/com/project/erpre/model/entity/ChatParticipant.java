package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "m_chat_participant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChatParticipant {

    @EmbeddedId
    private ChatParticipantId chatParticipantId;

    @Column(nullable = false, length = 50)
    private String chatTitle;

    @ManyToOne
    @MapsId("chatNo")
    @JoinColumn(name = "chat_no", nullable = false)
    private Chat chat;

    @ManyToOne
    @MapsId("participantId")
    @JoinColumn(name = "participant_id", nullable = false)
    private Employee employee;

}
