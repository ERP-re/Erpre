package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "m_chat")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatNo;

    @ManyToOne
    @JoinColumn(name = "chat_create_id", nullable = false)
    private Employee employee;

    @Column(nullable = false, length = 50)
    private String chatTitle;

    @Column(nullable = false)
    private LocalDateTime chatCreateDate;

    private LocalDateTime chatUpdateDate;

    @Column(nullable = false, length = 10)
    private String chatDeleteYn = "n";

    private LocalDateTime chatDeleteDate;

    @OneToMany(mappedBy = "chat")
    @JsonIgnore
    @ToString.Exclude
    private List<ChatParticipant> chatParticipantList;

    @OneToMany(mappedBy = "chat")
    @JsonIgnore
    @ToString.Exclude
    private List<ChatMessage> chatMessageList;
}
