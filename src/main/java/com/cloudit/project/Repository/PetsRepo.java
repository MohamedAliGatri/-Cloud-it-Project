package com.cloudit.project.Repository;

import com.cloudit.project.ExeptionHnadler.PetsNotFoundExeption;
import com.cloudit.project.enumeration.typePlants;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Plants;
import com.cloudit.project.model.Projects;
import com.cloudit.project.enumeration.typePets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PetsRepo extends JpaRepository<Pets, Long> {

    @Query(value="SELECT * FROM Pets WHERE project_id = :type", nativeQuery = true)
    List<Pets> findByIdprojet(@Param("type") float id);
    // Ajouter cette méthode personnalisée
    public static boolean ExistsByNameAndTypeAndProject(Long id, typePets type, Projects project) {
        return PetsRepo.ExistsByNameAndTypeAndProject(id, type, project);
    }
    default boolean isPetsAlreadyAssociatedWithAnotherProjects(long id, typePets type, Projects project) {
        return !this.findAllByTypeAndProjectAndIdIsNot(type, project, id).isEmpty();
    }
    List<Plants> findAllByTypeAndProjectAndIdIsNot(typePets type, Projects project, Long id);

    Optional<Object> findPetsById(Long id);

    void deletePetsById(Long id);

   // boolean isPetsAlreadyAssociatedWithAnotherProjects(long id, typePets type, Projects project);
}
