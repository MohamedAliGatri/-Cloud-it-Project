package com.cloudit.project.controller;

import com.cloudit.project.model.Conge;
import com.cloudit.project.service.congeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/conges")
public class CongeController {
    @Autowired
    private congeServices congeService;

    @GetMapping("/{id}")
    public ResponseEntity<Conge> getCongeById(@PathVariable Integer id) {
        Conge conge = congeService.getCongeById(id);
        return ResponseEntity.ok().body(conge);
    }

    @GetMapping("/")
    public ResponseEntity<List<Conge>> getAllConges() {
        List<Conge> conges = congeService.getAllConges();
        return ResponseEntity.ok().body(conges);
    }

    @PostMapping("/")
    public ResponseEntity<Conge> createConge(@RequestBody Conge conge) {
        Conge createdConge = congeService.saveConge(conge);
        return ResponseEntity.created(null).body(createdConge);
    }

    @PutMapping("/")
    public ResponseEntity<Conge> updateConge(@RequestBody Conge conge) {
        Conge updatedConge = congeService.updateConge(conge);
        return ResponseEntity.ok().body(updatedConge);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConge(@PathVariable Integer id) {
        congeService.deleteConge(congeService.getCongeById(id));
        return ResponseEntity.noContent().build();
    }
}