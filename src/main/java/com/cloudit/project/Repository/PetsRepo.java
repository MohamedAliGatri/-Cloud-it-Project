package com.cloudit.project.Repository;

import com.cloudit.project.ExeptionHnadler.PetsNotFoundExeption;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Projects;
import com.cloudit.project.enumeration.typePets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetsRepo extends JpaRepository<Pets, Long> {
    // Ajouter cette méthode personnalisée
    Pets findByProjectId(Long projectId);
    public static boolean ExistsByNameAndTypeAndProject(Long id, typePets type, Projects project) {
        return PetsRepo.ExistsByNameAndTypeAndProject(id, type, project);
    }

    Optional<Object> findPetsById(Long id);

    void deletePetsById(Long id);

   // boolean isPetsAlreadyAssociatedWithAnotherProjects(long id, typePets type, Projects project);
}
