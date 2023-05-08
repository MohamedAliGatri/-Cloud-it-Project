package com.cloudit.project.model;

import com.cloudit.project.enumeration.typePlants;
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
@Table(name = "Plants")

public class Plants extends  species implements Serializable {
    @Column(nullable = false)
    @Enumerated()
    private typePlants type;
    @Column(nullable = false)
    private float SoilQuality_quota;
    @Column(nullable = false)
    private float Nutriments_quota;
    @Column(nullable = false)
    private float Prune_quota;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer"})

    Projects project;


}