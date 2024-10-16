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
public class MessageRecipientFileDTO {

    private Integer messageNo;
    private String recipientId;
    private Integer messageAttachmentId;
    private String deleteYn;
    private LocalDateTime deleteDate;


}
