package com.cloudit.project.Repository;

import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Plants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetsRepo extends JpaRepository<Pets, Long> {
    Optional<Object> findPetsById(Long id);

    void deletePetsById(Long id);
}
