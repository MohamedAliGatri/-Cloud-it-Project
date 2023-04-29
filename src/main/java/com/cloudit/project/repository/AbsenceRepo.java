package com.cloudit.project.repository;

import com.cloudit.project.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepo extends JpaRepository <Absence,Integer> {
}
