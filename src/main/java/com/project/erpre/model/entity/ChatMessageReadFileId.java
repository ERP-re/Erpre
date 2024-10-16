package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ChatMessageReadFileId implements Serializable {

    private ChatMessageReadId chatMessageReadId;
    private Long chatAttachmentId;

}
