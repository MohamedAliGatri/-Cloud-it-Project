package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.PieceIdentite;
import com.cloudit.project.Repository.PieceIdentiteRepo;
import com.cloudit.project.service.PieceIdentiteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PieceIdentiteServicelmpl implements PieceIdentiteServices {
    @Autowired
    private PieceIdentiteRepo pieceIdentiteRepository;

    @Override
    public PieceIdentite addPieceIdentite(PieceIdentite pieceIdentite) {
        if (pieceIdentite.getNum_pieceid() == null  ||
                pieceIdentite.getType_pieceid() == null || pieceIdentite.getType_pieceid().isEmpty() ||
                pieceIdentite.getDate_delieve_piece() == null ||
                pieceIdentite.getLieu_delive_piece() == null || pieceIdentite.getLieu_delive_piece().isEmpty()) {
            throw new IllegalArgumentException("Tous les champs sont obligatoires");
        }
        return pieceIdentiteRepository.save(pieceIdentite);
    }

    @Override
    public List<PieceIdentite> getAllPieceIdentites() {
        return pieceIdentiteRepository.findAll();
    }

    @Override
    public PieceIdentite getPieceIdentiteById(Integer id) {
        Optional<PieceIdentite> optionalPieceIdentite = pieceIdentiteRepository.findById(id);
        if (optionalPieceIdentite.isEmpty()) {
            throw new NoSuchElementException("La pièce d'identité avec l'ID " + id + " n'existe pas");
        }
        return optionalPieceIdentite.get();
    }

    @Override
    public void deletePieceIdentite(Integer id) {
        if (!pieceIdentiteRepository.existsById(id)) {
            throw new NoSuchElementException("La pièce d'identité avec l'ID " + id + " n'existe pas");
        }
        pieceIdentiteRepository.deleteById(id);
    }
}

