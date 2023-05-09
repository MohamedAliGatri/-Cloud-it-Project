package com.cloudit.project.controller;

import com.cloudit.project.model.Employe;
import com.cloudit.project.model.PieceIdentite;
import com.cloudit.project.service.EmployeServices;
import com.cloudit.project.service.PieceIdentiteServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/pieceIdentites/")
@CrossOrigin("*")
public class PieceIdentiteController {

    @Autowired
    private PieceIdentiteServices pieceIdentiteService;
    @Autowired
    private EmployeServices employeServices;

    @PostMapping("")
    public ResponseEntity<PieceIdentite> addPieceIdentite(@Valid @RequestBody PieceIdentite pieceIdentite) {
        PieceIdentite savedPieceIdentite = pieceIdentiteService.addPieceIdentite(pieceIdentite);
        return ResponseEntity.ok(savedPieceIdentite);
    }

    @GetMapping("")
    public ResponseEntity<List<PieceIdentite>> getAllPieceIdentites() {
        List<PieceIdentite> pieceIdentites = pieceIdentiteService.getAllPieceIdentites();
        return ResponseEntity.ok(pieceIdentites);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PieceIdentite> getPieceIdentiteById(@PathVariable("id") Integer id) {
        PieceIdentite pieceIdentite = pieceIdentiteService.getPieceIdentiteById(id);
        return ResponseEntity.ok(pieceIdentite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PieceIdentite> updatePieceIdentite(@PathVariable("id") Double id, @Valid @RequestBody PieceIdentite pieceIdentite) {
        pieceIdentite.setNum_pieceid(id);
        PieceIdentite updatedPieceIdentite = pieceIdentiteService.addPieceIdentite(pieceIdentite);
        return ResponseEntity.ok(updatedPieceIdentite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePieceIdentite(@PathVariable("id") Integer id) {
        pieceIdentiteService.deletePieceIdentite(id);
        return ResponseEntity.noContent().build();
    }
}