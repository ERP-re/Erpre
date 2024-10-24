package com.project.erpre.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    private Long messageNo;
    private String messageSenderId;
    private String messageContent;
    private LocalDateTime messageSendDate;
    private LocalDateTime messageUpdateDate;
    private String messageDeleteYn;
    private LocalDateTime messageDeleteDate;
    private String messageRecallYn;
    private LocalDateTime messageRecallDate;

}
