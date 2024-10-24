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
public class ChatParticipantDTO {

    private Long chatNo;
    private String participantId;
    private String chatTitle;
}
