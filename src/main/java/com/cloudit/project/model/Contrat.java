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
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_contrat;
    String type_contrat;
    @Temporal(TemporalType.DATE)
    Date date_debut_cont;
    @Temporal(TemporalType.DATE)
    Date date_fin_cont;
    String motif_choix_cdd;
    String duree_acrt;
    @OneToOne
    Employe employe;
}
