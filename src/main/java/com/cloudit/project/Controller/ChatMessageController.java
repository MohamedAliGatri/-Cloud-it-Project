package com.cloudit.project.Controller;

import com.cloudit.project.payload.MessagePayload;
import com.cloudit.project.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/chat")
public class ChatMessageController {
    final MessageService messageService;
    final SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping
    @MessageMapping("/chat.private")
    public void sendMessage(MessagePayload messagePayload){
        messageService.sendMessage(messagePayload);
        simpMessagingTemplate.convertAndSendToUser(messagePayload.getReceiver(),
                "/queue/private", "[" + messagePayload.getSender() + "]: " + messagePayload.getContent());
    }
}
