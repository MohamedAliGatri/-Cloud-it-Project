package com.cloudit.project.model;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "species")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@MappedSuperclass
public  class species implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable = false,updatable = false)
    private long Id;
    private float Water_Quota;
    private float Employee_quota;
    private int Age_Months;
    private float area_quota_m;
    @ManyToOne
    private Projects project;







}
