package com.cloudit.project.Repository;

import com.cloudit.project.enumeration.typePets;
import com.cloudit.project.enumeration.typePlants;
import com.cloudit.project.model.Plants;
import com.cloudit.project.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlantsRepo extends JpaRepository<Plants, Long> {
    Optional<Object> findPlantsById(Long id);
    default boolean isPlantsAlreadyAssociatedWithAnotherProjects(long id, typePlants type, Projects project) {
        return !this.findAllByTypeAndProjectAndIdIsNot(type, project, id).isEmpty();
    }
    List<Plants> findAllByTypeAndProjectAndIdIsNot(typePlants type, Projects project, Long id);

    void deletePlantsById(Long id);





    public static boolean ExistsByNameAndTypeAndProject(Long id, typePets type, Projects project) {
        return PetsRepo.ExistsByNameAndTypeAndProject(id, type, project);
    }


}
