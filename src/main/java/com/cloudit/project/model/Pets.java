package com.cloudit.project.model;
import com.cloudit.project.enumeration.typePets;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Pets extends  species implements Serializable {
    @Enumerated
    @Column(nullable = false)
    private typePets type;
    @Column(nullable = false)
    private float weights;
    private float Shelter_quota;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer"})

    Projects project;


}
