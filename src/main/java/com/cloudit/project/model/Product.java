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
@ToString
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_product;
    String product_name;
    //@Enumerated(EnumType.STRING)
    //Category product_category;
    float price;
    String picture;
    Float quantity;
    String description;

    //@ManyToMany(mappedBy = "products")
    //private Set<Cart> products = new HashSet<>();
    //@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    //private List<Order> orderItems;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    Category category ;
    /*@OneToMany(mappedBy = "category")
    List<Cart> listeCarts;*/
    //many to one category objet
    //onetomany commande liste
    @OneToMany(mappedBy = "prod")
    @ToString.Exclude
    @JsonIgnore
    List<CartLine> ListeCarts = new ArrayList<>();

}
