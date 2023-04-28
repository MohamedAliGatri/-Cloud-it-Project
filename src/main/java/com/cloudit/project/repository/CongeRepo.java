package com.cloudit.project.repository;

import com.cloudit.project.model.Conge;
import com.cloudit.project.model.Employe;
import com.cloudit.project.model.TypeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

@Repository
public interface CongeRepo extends JpaRepository<Conge,Integer> {

}
