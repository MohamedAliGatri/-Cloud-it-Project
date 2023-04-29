package com.cloudit.project.controller;

import com.cloudit.project.model.Employe;
import com.cloudit.project.service.EmployeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployeController {

    @Autowired
    private EmployeServices employeServices;

    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeServices.getAllEmployes();
    }

    @GetMapping("/{mat_emp}")
    public Employe getEmployeById(@PathVariable Integer mat_emp) {
        return employeServices.getEmployeById(mat_emp);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeServices.saveEmploye(employe);
    }

    @PutMapping("/{mat_emp}")
    public Employe updateEmploye(@PathVariable Integer mat_emp, @RequestBody Employe employe) {
        employe.setMat_emp(mat_emp);
        return employeServices.updateEmploye(employe);
    }

    @DeleteMapping("/{mat_emp}")
    public void deleteEmploye(@PathVariable Integer mat_emp) {
        employeServices.deleteEmploye(mat_emp);
    }

}