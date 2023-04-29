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
public class Grade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_grade;
    Double salaire_base;
    @JsonIgnore
    @OneToMany(mappedBy = "grade", cascade = CascadeType.REMOVE)
    Set<Employe> employes;

}
