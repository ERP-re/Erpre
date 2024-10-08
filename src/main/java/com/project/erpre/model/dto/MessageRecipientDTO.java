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
public class MessageRecipientDTO {

    private Long messageNo;
    private String recipientId;
    private String recipientReadYn;
    private LocalDateTime recipientReadDate;
    private String recipientDeleteYn;
    private LocalDateTime recipientDeleteDate;
}
