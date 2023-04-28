package com.cloudit.project.service;

import com.cloudit.project.ExeptionHnadler.PlantsNotFoundExeption;
import com.cloudit.project.ExeptionHnadler.ProjectsNotFoundExeption;
import com.cloudit.project.Repository.PlantsRepo;
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

    public Plants addPlants(Plants Plant) {

        return pl_Repository.save(Plant);
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

    public void deletePlants(Long id){
        pl_Repository.deletePlantsById(id);
    }
}
