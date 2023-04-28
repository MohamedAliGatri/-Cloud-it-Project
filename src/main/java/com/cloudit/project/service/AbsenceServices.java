package com.cloudit.project.service;


import com.cloudit.project.model.Absence;
import com.cloudit.project.model.Conge;

import java.util.List;

public interface AbsenceServices {
   Absence saveAbsence(Absence absence);
   Absence updateAbsence(Absence absence);
   void deleteAbsence(Absence absence);
   Absence getAbsenceById(Integer id_absence);
    List<Absence> getAllAbsences();
}
