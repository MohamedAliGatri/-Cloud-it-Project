package com.cloudit.project.service;

import com.cloudit.project.model.PieceIdentite;
import com.cloudit.project.repository.PieceIdentiteRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PieceIdentiteServices {
    PieceIdentite addPieceIdentite(PieceIdentite pieceIdentite);
    List<PieceIdentite> getAllPieceIdentites();
    PieceIdentite getPieceIdentiteById(Integer id);
    void deletePieceIdentite(Integer id);
}

