package com.cloudit.project.service;

import com.cloudit.project.model.ChatMessage;
import com.cloudit.project.payload.MessagePayload;

public interface MessageService {
    ChatMessage sendMessage(MessagePayload messagePayload);
}
