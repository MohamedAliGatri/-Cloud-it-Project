package com.cloudit.project.repository;

import com.cloudit.project.model.PieceIdentite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceIdentiteRepo extends JpaRepository<PieceIdentite,Integer> {
}
