package com.cloudit.project.Controller;

import com.cloudit.project.ExeptionHnadler.PetsNotFoundExeption;
import com.cloudit.project.ExeptionHnadler.PlantsNotFoundExeption;
import com.cloudit.project.Repository.PlantsRepo;
import com.cloudit.project.Repository.ProjectsRepo;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Plants;
import com.cloudit.project.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
    @RequestMapping("/api/plants")
    public class PlantsController {
    @Autowired
    private ProjectsRepo projectrepository;
        @Autowired
        private PlantsRepo plantsRepository;

        @GetMapping
        public List<Plants> getAllPlants() {

            return plantsRepository.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Plants> getPlantById(@PathVariable Long id) {
            Optional<Plants> plant = plantsRepository.findById(id);
            if (plant.isPresent()) {
                return ResponseEntity.ok(plant.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        public ResponseEntity<Plants> createPlant(@RequestBody Plants plant) {
            Plants savedPlant = plantsRepository.save(plant);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPlant);
        }

    @PostMapping("/AffectPlant")
    public ResponseEntity<Object> create(@RequestBody Plants plant, @RequestParam long projectId) {
        try {
            if (plantsRepository.isPlantsAlreadyAssociatedWithAnotherProjects(plant.getId(), plant.getType(), projectrepository.getOne(projectId))) {
             throw new PetsNotFoundExeption("This plant already exists in the project");
            }
            Projects project = projectrepository.getOne(projectId);
            plant.setProject(project);
            Plants savedPet = plantsRepository.save(plant);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedPet.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (PetsNotFoundExeption ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plants> updatePlant(@PathVariable(value = "id") Long plantId, @RequestBody Plants plantDetails) {
        Plants plant = plantsRepository.findById(plantId)
                .orElseThrow(() -> new PlantsNotFoundExeption("Plant", "id", plantId));

        // Update plant details
        plant.setArea_quota_m(plantDetails.getArea_quota_m());
        plant.setAge_Months(plantDetails.getAge_Months());
        plant.setEmployee_quota(plantDetails.getEmployee_quota());
        plant.setWater_Quota(plantDetails.getWater_Quota());
        plant.setPrune_quota(plantDetails.getPrune_quota());
        plant.setNutriments_quota(plantDetails.getNutriments_quota());
        plant.setSoilQuality_quota(plantDetails.getSoilQuality_quota());

        // Set the project of the plant
        Projects project = plantDetails.getProject();
        if (project != null) {
            plant.setProject(project);
        }

        Plants updatedPlant = plantsRepository.save(plant);
        return ResponseEntity.ok(updatedPlant);
    }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deletePlant(@PathVariable Long id) {
            Optional<Plants> plant = plantsRepository.findById(id);
            if (plant.isPresent()) {
                plantsRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    }


