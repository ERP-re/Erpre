package com.project.erpre.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChatMessageReadId implements Serializable {

    private Long chatMessageNo;
    private String chatMessageRecipientId;
}
