package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.ChatMessage;
import com.cloudit.project.model.User;
import com.cloudit.project.payload.MessagePayload;
import com.cloudit.project.repository.MessageRepository;
import com.cloudit.project.repository.UserRepository;
import com.cloudit.project.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImplementation implements MessageService {
    final UserRepository userRepository;
    final MessageRepository messageRepository;
    @Override
    public ChatMessage sendMessage(MessagePayload messagePayload) {
        User sender=userRepository.findByUsername(messagePayload.getSender());
        User receiver = userRepository.findByUsername(messagePayload.getReceiver());
        ChatMessage message= ChatMessage.builder()
                .sender(sender)
                .receiver(receiver)
                .content(messagePayload.getContent())
                .build();
        return messageRepository.save(message);
    }
}
