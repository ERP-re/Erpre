package com.project.erpre.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 메세지의 구조 정의
public class TalkMessage {
    private String sender;
    private String content;
    private String timestamp;
    private String fileUrl;

}
