package com.cloudit.project.service;


import com.cloudit.project.model.Employe;

import java.util.List;

public interface EmployeServices {
    Employe saveEmploye(Employe employe);
    Employe updateEmploye(Employe employe);
    void deleteEmploye(Integer mat_emp);
    Employe getEmployeById(Integer mat_emp);
    List<Employe> getAllEmployes();

}
