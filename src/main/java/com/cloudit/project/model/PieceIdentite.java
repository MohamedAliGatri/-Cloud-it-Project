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
public class PieceIdentite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_pieceId_emp;
    String num_pieceid;
    String type_pieceid;
    @Temporal(TemporalType.DATE)
    Date date_delieve_piece;
    String lieu_delive_piece;
    @OneToOne
    Employe employe;
}
