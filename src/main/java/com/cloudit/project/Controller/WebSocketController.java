package com.cloudit.project.Controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WebSocketController {
    final SimpMessagingTemplate simpMessagingTemplate;
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
    /*@MessageMapping("/chat.private")
    public void sendPrivateMessage(Principal principal){
        String sender=principal.getName();
        String receiver="mohamed";
        String message="hello chat";
        simpMessagingTemplate.convertAndSendToUser(receiver, "/queue/private", "[" + sender + "]: " + message);

    }*/
}
