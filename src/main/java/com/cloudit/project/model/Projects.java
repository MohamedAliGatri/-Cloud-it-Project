package com.cloudit.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id;
     private long Budget;
     private float Duration_months;
     private float land_area;

     @JsonIgnore
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
        Set<Pets> PetsSet;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    Set<Plants> PlantsSet;



}
