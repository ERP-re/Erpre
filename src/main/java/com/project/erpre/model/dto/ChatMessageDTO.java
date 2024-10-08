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
public class ChatMessageDTO {

    private Long chatMessageNo;
    private Long chatNo;
    private String chatSenderId;
    private String chatMessageContent;
    private LocalDateTime chatSendDate;
    private String chatMessageDeleteYn;
    private LocalDateTime chatMessageDeleteDate;

}
