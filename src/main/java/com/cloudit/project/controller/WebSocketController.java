package com.cloudit.project.controller;

import com.cloudit.project.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/chat.register")
    @SendTo("/chat/public")
    public String register(@Payload String chatMessage) {
        //SimpMessageHeaderAccessor headerAccessor
        //headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/chat/public")
    public String sendMessage(@Payload String chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/notification.drivers")
    @SendTo("/notification/drivers")
    public String sendNotificationToDrivers(@Payload String notification){
        return notification;
    }
}
