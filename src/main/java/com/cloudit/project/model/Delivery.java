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
public class Delivery {
    @SequenceGenerator(sequenceName = "delivery_id_seq",name = "delivery_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_id_seq")
    @Id
    Long deliveryId;
    String orderId;
    @OneToOne
    User client;
    @OneToOne
    User deliveryPerson;
    String status;
    Boolean isCancled;
    Boolean isTerminated;
}
