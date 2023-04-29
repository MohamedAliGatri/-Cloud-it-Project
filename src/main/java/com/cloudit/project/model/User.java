package com.cloudit.project.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @SequenceGenerator(sequenceName = "user_id_seq",name = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @Id
    Long id;
    String username;
    String role;
    String password;

    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }
}
