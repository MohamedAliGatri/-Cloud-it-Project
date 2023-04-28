package com.cloudit.project.Repository;

import com.cloudit.project.model.Plants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlantsRepo extends JpaRepository<Plants, Long> {
    Optional<Object> findPlantsById(Long id);

    void deletePlantsById(Long id);
}
