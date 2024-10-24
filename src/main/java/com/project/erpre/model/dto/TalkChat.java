package com.project.erpre.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 채팅의 구조 정의
public class TalkChat {
    private String chatId;
    private String message;
    private String sender;
    private String timeStamp;
    private String fileUrl;

}
