package com.project.erpre.model.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChatParticipantId implements Serializable {
    private Long chatNo;
    private String participantId;
}
