package com.cloudit.project.controller;

import com.cloudit.project.model.Absence;
import com.cloudit.project.service.AbsenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {
    @Autowired
    private AbsenceServices absenceService;

    @GetMapping("/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable("id") Integer id) {
        Absence absence = absenceService.getAbsenceById(id);
        return ResponseEntity.ok().body(absence);
    }

    @GetMapping
    public ResponseEntity<List<Absence>> getAllAbsences() {
        List<Absence> absences = absenceService.getAllAbsences();
        return ResponseEntity.ok().body(absences);
    }

    @PostMapping
    public ResponseEntity<Absence> createAbsence(@RequestBody @Validated Absence absence) {
        Absence newAbsence = absenceService.saveAbsence(absence);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAbsence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable("id") Integer id, @RequestBody @Validated Absence absence) {
        Absence updatedAbsence = absenceService.updateAbsence(absence);
        return ResponseEntity.ok().body(updatedAbsence);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable("id") Integer id) {
        Absence absence = absenceService.getAbsenceById(id);
        absenceService.deleteAbsence(absence);
        return ResponseEntity.noContent().build();
    }
}