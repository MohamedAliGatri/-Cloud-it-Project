package com.cloudit.project.Repository;

import com.cloudit.project.model.Absence;
import com.cloudit.project.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EmployeRepo extends JpaRepository<Employe,Integer> {
    Employe findByNumtelemp(Double num_tel_emp);
    @Query("SELECT e FROM Employe e WHERE e.mat_emp NOT IN "
            + "(SELECT a.employes.mat_emp FROM Absence a WHERE a.date_absence = :date)")
    List<Employe> findByAbsencesDateAndAbsences(Date date);
}