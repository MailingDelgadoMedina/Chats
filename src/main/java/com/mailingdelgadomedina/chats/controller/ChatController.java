package com.mailingdelgadomedina.chats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.mailingdelgadomedina.chats.controller.model.Message;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message") // /app/message
    @SendTo("/chatroom/public")
    private Message recievePublicMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/private-message")
  public Message recievePrivateMessage(@Payload Message message) {
    simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/chatroom/private", message); // /user/{username}/private
    return message;
  }

}
