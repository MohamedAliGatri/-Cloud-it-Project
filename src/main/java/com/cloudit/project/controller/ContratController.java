package com.cloudit.project.controller;

import com.cloudit.project.model.Contrat;
import com.cloudit.project.repository.ContratRepo;
import com.cloudit.project.service.ContratServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/contrats")
public class ContratController {

    @Autowired
    private ContratServices contratService;

    @PostMapping("/")
    public Contrat saveContrat(@RequestBody Contrat contrat) {
        return contratService.saveContrat(contrat);
    }

    @PutMapping("/")
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return contratService.updateContrat(contrat);
    }

    @DeleteMapping("/{id}")
    public void deleteContrat(@PathVariable Integer id) {
        Contrat contrat = contratService.getContratById(id);
        contratService.deleteContrat(contrat);
    }

    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable Integer id) {
        return contratService.getContratById(id);
    }

    @GetMapping("/")
    public List<Contrat> getAllContrats() {
        return contratService.getAllContrats();
    }
}