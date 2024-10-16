package com.project.erpre.model.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChatMessageReadId implements Serializable {

    private Long chatMessageNo;
    private String chatMessageRecipientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatMessageReadId that = (ChatMessageReadId) o;
        return Objects.equals(chatMessageNo, that.chatMessageNo) &&
                Objects.equals(chatMessageRecipientId, that.chatMessageRecipientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatMessageNo, chatMessageRecipientId);
    }

}
