package com.project.erpre.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 클라이언트가 연결할 수 있는 웹소켓 엔드포인트(접속 지점)를 "/ws"로 설정
        registry.addEndpoint("/talk").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 클라이언트가 메시지를 전송할 때 "/app"으로 시작하도록 설정
        config.setApplicationDestinationPrefixes("/app");
        // 구독 경로를 "/topic"으로 설정
        // 구독 - 클라이언트가 특정 주제를 구독하면 서버가 그 주제와 관련된 메시지를 클라이언트에게 푸시해주는 기능
        config.enableSimpleBroker("/topic");
    }
}
