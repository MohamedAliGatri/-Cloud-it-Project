package com.cloudit.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_linecart;

    @ManyToOne
    @JsonIgnore
    Cart panier;

    Integer quantie;
    float prix ;

    @ManyToOne
    Product prod;
    @JsonIgnore
    @ManyToOne
    Orderr ordre;
}