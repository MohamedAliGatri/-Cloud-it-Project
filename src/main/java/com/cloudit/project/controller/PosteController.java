package com.cloudit.project.controller;
import com.cloudit.project.model.Employe;
import com.cloudit.project.model.Grade;
import com.cloudit.project.model.Poste;
import com.cloudit.project.service.PosteServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/postes/")
@CrossOrigin("*")

public class PosteController {
    @Autowired
    private PosteServices posteService;

    @PostMapping("")
    public ResponseEntity<Poste> addPoste(@RequestBody Poste poste) {
        try {
            Poste newPoste = posteService.addPoste(poste);
            return ResponseEntity.ok(newPoste);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("")
    public List<Poste> getAllPostes() {
        return posteService.getAllPostes();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Poste> updatePoste(@PathVariable Integer id, @Valid @RequestBody Poste poste) {
        Poste updatedPoste = posteService.updatePoste(id, poste);
        return ResponseEntity.ok(updatedPoste);
    }
    @GetMapping("{id}")
    public ResponseEntity<Poste> getPosteById(@PathVariable Integer id) {
        try {
            Poste poste = posteService.getPosteById(id);
            return ResponseEntity.ok(poste);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePoste(@PathVariable Integer id) {
        posteService.deletePoste(id);
        return ResponseEntity.noContent().build();
    }
}
