package com.cloudit.project.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Orders> orders = new HashSet<>();
    public void add(Orders order) {

        if (order != null) {

            if (orders == null) {
                orders = new HashSet<>();
            }

            orders.add(order);
            order.setCustomer(this);
        }
    }
}
