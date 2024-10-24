package com.project.erpre.controller;

import com.project.erpre.model.dto.TalkChat;
import com.project.erpre.model.dto.TalkMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

// 웹소켓 메시지 커치
// 클라이언트 간 실시간 메시지 전송 (채팅, 쪽지, 알림 등)
// STOMP 프로토콜을 이용해 메시지를 처리하고 브로드캐스트
@Controller
public class TalkController {

    // 쪽지(Message) 전송
    @MessageMapping("/talk/message") // 클라이언트가 메시지를 "/app/talk/message"으로 보내면 호출됨
    @SendTo("/topic/message") // 모든 클라이언트에게 메시지를 "/topic/message" 경로로 전송
    public TalkMessage send(TalkMessage message) {
        return message; // 실시간 쪽지를 그대로 반환하여 모든 구독자에게 전달
    }

    // 채팅(Chat) 전송
    @MessageMapping("/talk/chat")
    @SendTo("/topic/chat")
    public TalkChat send(TalkChat chat) {
        return chat; // 실시간 채팅을 그대로 반환하여 모든 구독자에게 전달
    }

}
