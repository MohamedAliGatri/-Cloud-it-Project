package com.cloudit.project.repository;

import com.cloudit.project.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepo extends JpaRepository<Contrat,Integer> {

}
