package com.cloudit.project.Repository;

import com.cloudit.project.model.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeRepo extends JpaRepository<Conge,Integer> {

}
