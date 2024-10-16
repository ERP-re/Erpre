package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ChatMessageReadId implements Serializable {

    @Column(name = "chat_message_no")
    private Long chatMessageNo;

    @Column(name = "chat_message_recipient_id")
    private String chatMessageRecipientId;

}
