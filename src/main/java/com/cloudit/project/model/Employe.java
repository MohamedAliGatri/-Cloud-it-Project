package com.cloudit.project.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Getter
@Entity
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer mat_emp;
    String civilite_emp;
    String situation_fam_emp;
    String nom_emp;
    String prenom_emp;
    @Temporal(TemporalType.DATE)
    Date dns_emp;
    String lieu_ns_emp;
    String adresse_emp;
    Integer num_tel_emp;
    Integer num_ss_emp;
    Integer num_cb_emp;
    Integer id_contrat;
    Integer id_grade;
    @JsonIgnore
    @OneToOne(mappedBy = "employe")
    PieceIdentite pieceIdentite;
    @ManyToOne(cascade = CascadeType.PERSIST)
    Contrat contrat;
    @ManyToOne(cascade = CascadeType.PERSIST)
    Grade grade;
    @OneToOne(mappedBy = "employe", cascade = CascadeType.REMOVE)
    Absence absence;
    @OneToMany (mappedBy = "employe")
    Set<Conge> Conge;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnore
    Set<Poste> postes;

}