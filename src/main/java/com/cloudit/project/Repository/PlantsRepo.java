package com.cloudit.project.Repository;

import com.cloudit.project.enumeration.typePets;
import com.cloudit.project.enumeration.typePlants;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Plants;
import com.cloudit.project.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlantsRepo extends JpaRepository<Plants, Long> {
    Optional<Object> findPlantsById(Long id);
    default boolean isPlantsAlreadyAssociatedWithAnotherProjects(long id, typePlants type, Projects project) {
        return !this.findAllByTypeAndProjectAndIdIsNot(type, project, id).isEmpty();
    }
    List<Plants> findAllByTypeAndProjectAndIdIsNot(typePlants type, Projects project, Long id);

    void deletePlantsById(Long id);
    @Query(value="SELECT * FROM Plants WHERE project_id = :type", nativeQuery = true)
    List<Plants> findByIdprojet(@Param("type") float id);

    @Query(value="SELECT * FROM projects WHERE id = :idproj", nativeQuery = true)
    Projects findMyProject(@Param("idproj") float id);

    @Query(value="UPDATE  Plants set project_id = :idProj where Plants.id = :idplante", nativeQuery = true)
    List<Plants> resetidproj(@Param("idProj") float id,@Param("idplante") float idplante);




    public static boolean ExistsByNameAndTypeAndProject(Long id, typePets type, Projects project) {
        return PetsRepo.ExistsByNameAndTypeAndProject(id, type, project);
    }


}
