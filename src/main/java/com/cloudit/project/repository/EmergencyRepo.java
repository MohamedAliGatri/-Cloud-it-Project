package com.cloudit.project.repository;

import com.cloudit.project.model.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRepo extends JpaRepository<Emergency,Long> {
}
