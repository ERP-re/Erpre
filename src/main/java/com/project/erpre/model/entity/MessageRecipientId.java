package com.project.erpre.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

// 복합키 정의
@Embeddable
public class MessageRecipientId implements Serializable {
    private Long messageNo;
    private Long recipientId;
}
