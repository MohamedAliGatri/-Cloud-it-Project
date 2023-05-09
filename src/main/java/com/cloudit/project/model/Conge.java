package com.cloudit.project.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;
@Getter
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Conge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_cong;
    String duree_cong;
    @Temporal(TemporalType.DATE)
    Date date_etab_titreConge;
    @Temporal(TemporalType.DATE)
    Date date_debutConge;
    @Temporal(TemporalType.DATE)
    Date date_finConge;
    @Temporal(TemporalType.DATE)
    Date date_reprise;
    @Temporal(TemporalType.DATE)
    Date date_nonReprise;
    @ManyToOne
    Employe employe;
    @Enumerated(EnumType.STRING)
    TypeConge typeConge;
    //Arret
    String desg_arret;
    //Annuel
    @Temporal(TemporalType.DATE)
    Year annee_Conge;
    Integer solde_conge;
    //exceptionnel
    String annee_Conge_excep;
}
