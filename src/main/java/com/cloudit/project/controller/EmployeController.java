package com.cloudit.project.controller;

import com.cloudit.project.model.Employe;
import com.cloudit.project.repository.EmployeRepo;
import com.cloudit.project.service.EmployeServices;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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