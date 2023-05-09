package com.cloudit.project.service;


import com.cloudit.project.model.Employe;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeServices {

    Employe saveEmploye(Employe employe);
    Employe updateEmploye(Integer Id,Employe employe);
    void deleteEmploye(Integer mat_emp);
    Employe getEmployeById(Integer mat_emp);
    List<Employe> getAllEmployes();
    Employe getEmployeByNumTelEmp(Double NumTel);
    List<Employe> getAllEmployesAbsence(Date date);


}
