package com.cloudit.project.controller;

import com.cloudit.project.model.Grade;
import com.cloudit.project.repository.GradeRepo;
import com.cloudit.project.service.GradeServices;
import jakarta.validation.Valid;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    GradeServices gradeService;

    @PostMapping
    public ResponseEntity<Grade> saveGrade(@Valid @RequestBody Grade grade) {
        Grade savedGrade = gradeService.saveGrade(grade);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGrade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Integer id, @Valid @RequestBody Grade grade) {
        Grade updatedGrade = gradeService.updateGrade(id, grade);
        return ResponseEntity.ok(updatedGrade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Integer id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Integer id) {
        Grade grade = gradeService.getGradeById(id);
        return ResponseEntity.ok(grade);
    }

    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        return ResponseEntity.ok(grades);
    }
}
