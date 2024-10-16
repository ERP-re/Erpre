package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ChatParticipantId implements Serializable {

    private Long chatNo;
    private String participantId;

}
