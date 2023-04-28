package com.cloudit.project.repository;

import com.cloudit.project.model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PosteRepo extends JpaRepository<Poste,Integer> {
   Poste findByDesgPoste(String DesgPoste);
}
