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
public class ChatMessageReadFileId implements Serializable {


    @Embedded
    private ChatMessageReadId chatMessageReadId;

    private Long chatAttachmentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatMessageReadFileId)) return false;
        ChatMessageReadFileId that = (ChatMessageReadFileId) o;
        return Objects.equals(chatMessageReadId, that.chatMessageReadId) &&
                Objects.equals(chatAttachmentId, that.chatAttachmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatMessageReadId, chatAttachmentId);
    }


}
