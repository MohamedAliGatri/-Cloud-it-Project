package com.cloudit.project.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    Double numtelemp;
    Double num_ss_emp;
    Double num_cb_emp;
    @OneToOne
    PieceIdentite pieceIdentite;
    @OneToOne(mappedBy = "employe", cascade = CascadeType.REMOVE)
    Contrat contrat;
    @ManyToOne( cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    Grade grade;
    @OneToMany(mappedBy = "employes", cascade = CascadeType.REMOVE)
    @JsonIgnore
    @ToString.Exclude
    Set<Absence> absences;
    @OneToMany (mappedBy = "employe")
    Set<Conge> Conge;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    Poste poste;

}