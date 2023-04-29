package com.cloudit.project.service;

import com.cloudit.project.model.PieceIdentite;

import java.util.List;
public interface PieceIdentiteServices {
    PieceIdentite addPieceIdentite(PieceIdentite pieceIdentite);
    List<PieceIdentite> getAllPieceIdentites();
    PieceIdentite getPieceIdentiteById(Integer id);
    void deletePieceIdentite(Integer id);
}

