package com.cloudit.project.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.Date;
@Getter
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
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
}
