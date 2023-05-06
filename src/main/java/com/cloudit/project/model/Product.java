package com.cloudit.project.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "product name is required")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "give a description for your product")
    private String description;


    @Column(name = "price")
    @NotNull(message = "price must be done")
    private BigDecimal prix;

    @Column(name = "quantity")
    @NotNull(message = "quantity must be done")
    private int quantity;

    @Column(name = "picture")
    private String picture;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private Date updatedDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryProduct category;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "image", fetch = FetchType.EAGER)
    private Set<MultiPicture> products;



    private Double etoile;
    @ElementCollection
    private Map<Long, Double> clientEtoile;
}
