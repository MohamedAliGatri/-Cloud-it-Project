package com.cloudit.project.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    @SequenceGenerator(sequenceName = "message_id_seq",name = "message_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_seq")
    @Id
    Long messageId;
    String content;
    @OneToOne
    User sender;
    @OneToOne
    User receiver;

}
