package com.cloudit.project.model;
import lombok.*;
import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;

import java.time.Year;
import java.util.Date;

@Getter
@Entity
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CongeAnnuel extends Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_congAnn;
    @Temporal(TemporalType.DATE)
    Year annee_Conge;
    Integer solde_conge;
    @ManyToOne
    Employe employe;
}