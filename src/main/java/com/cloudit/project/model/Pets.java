package com.cloudit.project.model;
import com.cloudit.project.enumeration.typePets;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pets")
public class Pets extends  species{
    @Enumerated
    @Column(nullable = false)
    private typePets type;
    @Column(nullable = false)
    private float weights;
    private float Shelter_quota;
    @ManyToOne
    Projects project;


}
