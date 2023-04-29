package com.cloudit.project.model;

import com.cloudit.project.enumeration.typePlants;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Plants")

public class Plants extends  species{
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
    Projects project;


}