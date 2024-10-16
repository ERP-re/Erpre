package com.project.erpre.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageReadFileDTO {

    private Integer chatMessageNo;
    private String recipientId;
    private Integer chatAttachmentId;
    private String deleteYn;
    private LocalDateTime deleteDate;
}
