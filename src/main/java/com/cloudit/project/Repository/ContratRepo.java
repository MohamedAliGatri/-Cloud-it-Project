package com.cloudit.project.Repository;

import com.cloudit.project.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepo extends JpaRepository<Contrat,Integer> {

}
