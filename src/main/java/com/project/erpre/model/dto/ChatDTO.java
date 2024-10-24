package com.project.erpre.model.dto;

import lombok.*;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatDTO {

    private Long chatNo;

    private String chatTitle;
    private String participantId;
    private String employeeName;
    private String chatMessageContent;
    private LocalDateTime chatSendDate;
    private String chatFilename;

    // 1. 현재 참여하고 있는 채팅 목록 조회 및 검색 생성자 (기본 생성자)



}
