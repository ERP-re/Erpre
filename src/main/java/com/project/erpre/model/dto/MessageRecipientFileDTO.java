package com.project.erpre.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageRecipientFileDTO {

    private Long messageNo;
    private String recipientId;
    private Long messageAttachmentId;
    private String deleteYn;

}
