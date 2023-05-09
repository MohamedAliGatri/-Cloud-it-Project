package com.cloudit.project.service;

import com.cloudit.project.ExeptionHnadler.PetsNotFoundExeption;
import com.cloudit.project.ExeptionHnadler.PlantsNotFoundExeption;
import com.cloudit.project.ExeptionHnadler.ProjectsNotFoundExeption;
import com.cloudit.project.Repository.PlantsRepo;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Plants;
import com.cloudit.project.model.Projects;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlantsService {
    private final PlantsRepo pl_Repository;
@Autowired
    public PlantsService(PlantsRepo plRepository) {

    pl_Repository = plRepository;
    }

    public Plants addPlants(Plants Plant, Projects project) {
        verifyPlantsNotExistInProject(Plant,project);
        return pl_Repository.save(Plant);
    }

    private void verifyPlantsNotExistInProject(Plants plant, Projects project) throws PetsNotFoundExeption {
        // Vérifier si un animal avec le même identifiant existe déjà dans le projet
        if ( pl_Repository.existsById(plant.getId())) {
            throw new PetsNotFoundExeption("Animal already exists in the project.");
        }
        // Vérifier si un animal avec le même nom et type existe déjà dans le projet
        if (pl_Repository.isPlantsAlreadyAssociatedWithAnotherProjects(plant.getId(), plant.getType(), project)) {
            throw new PetsNotFoundExeption("An animal with the same name and type already exists in the project.");
        }
    }

    public List<Plants> findAllPlants() {
        return pl_Repository.findAll();
    }

    public Plants updatePlants(Plants Plant) {
        return pl_Repository.save(Plant);
    }

    public Plants findPlantsById(Long id) {

        return (Plants) pl_Repository.findPlantsById(id)
                .orElseThrow(() -> new PlantsNotFoundExeption("Plant by id " + id + " was not found"));
    }

    public Projects findMine(long id)
    {
        return (Projects) pl_Repository.findMyProject(id);
    }

    public void deletePlants(Long id){
        pl_Repository.deletePlantsById(id);
    }
}
