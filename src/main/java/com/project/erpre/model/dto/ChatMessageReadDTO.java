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
public class ChatMessageReadDTO {

    private Long chatMessageNo;
    private String chatMessageRecipientId;
    private String chatMessageReadYn;
    private LocalDateTime chatMessageReadDate;

}
