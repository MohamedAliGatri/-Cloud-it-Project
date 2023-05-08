package com.cloudit.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Projects")
public class Projects implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id;
     private long Budget;
     private float Duration_months;
     private float land_area;
     private  String Title;
     private float idUser;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
     @JsonIgnore
         Set<Pets> PetsSet;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
     @JsonIgnore
         Set<Plants> PlantsSet;



}
