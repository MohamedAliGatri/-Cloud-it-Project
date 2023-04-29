package com.cloudit.project.repository;

import com.cloudit.project.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepo extends JpaRepository<Employe,Integer> {

}
