package com.cloudit.project.Repository;

import com.cloudit.project.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepo extends JpaRepository<Employe,Integer> {

}
