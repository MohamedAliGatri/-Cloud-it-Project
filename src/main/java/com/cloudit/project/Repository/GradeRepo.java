package com.cloudit.project.Repository;

import com.cloudit.project.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<Grade,Integer> {
}
