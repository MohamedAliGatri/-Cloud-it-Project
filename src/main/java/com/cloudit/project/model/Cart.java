package com.cloudit.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_cart;
    Integer quantity;
    //@ManyToOne
    //User user;
    @OneToMany(mappedBy = "panier")
    @JsonIgnore
    List<CartLine> cartLineList = new ArrayList<>();
}
