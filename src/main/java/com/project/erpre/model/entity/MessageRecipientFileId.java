package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRecipientFileId implements Serializable {

    private Long messageNo;
    private String recipientId;
    private Long messageAttachmentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageRecipientFileId that = (MessageRecipientFileId) o;
        return Objects.equals(messageNo, that.messageNo) &&
                Objects.equals(recipientId, that.recipientId) &&
                Objects.equals(messageAttachmentId, that.messageAttachmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageNo, recipientId, messageAttachmentId);
    }

}
