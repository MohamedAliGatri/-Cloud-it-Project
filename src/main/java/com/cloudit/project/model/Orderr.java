package com.cloudit.project.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Orderr implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_order;
    Date dateOrder;
    String status;

    @OneToMany(mappedBy = "ordre")
    List<CartLine> listePanier = new ArrayList<>();
    @OneToOne(mappedBy = "commande")
    User user;
}
