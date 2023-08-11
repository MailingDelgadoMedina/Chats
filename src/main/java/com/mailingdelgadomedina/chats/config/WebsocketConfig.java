package com.mailingdelgadomedina.chats.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;

@Configuration
@EnableWebSocketMessageBroker

public class WebsocketConfig implements WebSocketMessageBrokerConfigurer{
 
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
       registry.setApplicationDestinationPrefixes("/app");
         registry.enableSimpleBroker("/chatroom", "/user");
         registry.setUserDestinationPrefix("/user");
    }
 @Override
    registerStompEndpoints(StompEndpointRegistry registry) {
     WebSocketMessageBrokerConfigurationSupport.super.registerStompEndpoints(registry);
       registry.addEndpoint("/ws").setAllowedOriginsPatterns("*").withSockJS();
       // registry.addEndpoint("/chat").withSockJS();
   }
}
