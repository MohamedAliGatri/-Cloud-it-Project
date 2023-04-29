package com.cloudit.project.Repository;

import com.cloudit.project.model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PosteRepo extends JpaRepository<Poste,Integer> {
   Poste findByDesgPoste(String DesgPoste);
}
