package com.project.erpre.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="m_message")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageNo;

    @ManyToOne
    @JoinColumn(name = "message_sender_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private String messageContent;

    @Column(nullable = false)
    private LocalDateTime messageSendDate;

    private LocalDateTime messageUpdateDate;

    @Column(nullable = false, length = 10)
    private String messageDeleteYn = "n";

    private LocalDateTime messageDeleteDate;

    @Column(nullable = false, length = 10)
    private String messageRecallYn = "n";

    private LocalDateTime messageRecallDate;

    @OneToMany(mappedBy = "message", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<MessageRecipient> messageRecipientList;

}
