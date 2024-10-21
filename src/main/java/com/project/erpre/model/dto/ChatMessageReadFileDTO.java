package com.project.erpre.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageReadFileDTO {

    private Long chatMessageNo;
    private String recipientId;
    private Long chatAttachmentId;
    private String deleteYn;
}
