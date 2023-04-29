package com.cloudit.project.payload;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessagePayload {
    String content;
    String receiver;
    String sender;
}
