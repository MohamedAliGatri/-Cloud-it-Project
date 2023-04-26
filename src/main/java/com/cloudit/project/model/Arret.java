package com.cloudit.project.model;
import lombok.*;
import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;

@Getter
@Entity
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Arret extends Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_arret;
    String desg_arret;
    @ManyToOne
    Employe employe;
}
