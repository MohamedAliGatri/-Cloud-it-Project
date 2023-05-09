package com.cloudit.project.Controller;

import com.cloudit.project.ExeptionHnadler.PetsNotFoundExeption;
import com.cloudit.project.ExeptionHnadler.PlantsNotFoundExeption;
import com.cloudit.project.ExeptionHnadler.ProjectsNotFoundExeption;
import com.cloudit.project.Repository.PlantsRepo;
import com.cloudit.project.Repository.ProjectsRepo;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Plants;
import com.cloudit.project.model.Projects;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@Slf4j
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

    @GetMapping("myproj/{id}")
    public ResponseEntity<Projects> getproj(@PathVariable Long id) {
        Projects plante = plantsRepository.findMyProject(id);
        // if (plante.isEmpty()) {
        //    return ResponseEntity.notFound().build();
        //} else {
        return ResponseEntity.ok(plante);

        //}
    }


        @GetMapping("/{id}")
        public ResponseEntity<List<Plants>> getPlantById(@PathVariable Long id) {
           List<Plants> plante = plantsRepository.findByIdprojet(id);
            if ((plante)==null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(plante);

            }
    }


        @PostMapping
        public ResponseEntity<Plants> createPlant(@RequestBody Plants plant) {
            Plants savedPlant = plantsRepository.save(plant);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPlant);
        }

    @PostMapping("/affectplant/{projectId}")
    public ResponseEntity<Object> create(@RequestBody Plants plant, @PathVariable long projectId) {

          plant.setProject(projectrepository.findProjectsById(projectId));
        if ((projectrepository.findProjectsById(projectId))==null) {
            throw new ProjectsNotFoundExeption("ce projet n'existe pas veuillez creér un");
        }
        Plants savedPlant = plantsRepository.save(plant);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlant);


    }
@Modifying
     @Transactional
    @PutMapping("/updateee")
    public ResponseEntity<Plants> updatePlant(@RequestBody Plants plant) {
            Plants pp=plantsRepository.findById(plant.getId()).get();

            pp.setProject(pp.getProject());
            pp.setType(pp.getType());
            pp.setNutriments_quota(pp.getNutriments_quota());
            pp.setPrune_quota(pp.getPrune_quota());
            pp.setAge_Months(pp.getAge_Months());
            pp.setArea_quota_m(pp.getArea_quota_m());
            pp.setEmployee_quota(pp.getEmployee_quota());
            pp.setWater_Quota(pp.getWater_Quota());

        return ResponseEntity.ok(plantsRepository.save(pp));
    }
    @Modifying
    @Transactional
    @PutMapping("/update")
    public ResponseEntity<Plants> updatePlants( @RequestBody Plants updatedPlants) {
        Optional<Plants> optionalPlants = plantsRepository.findById(updatedPlants.getId());
        if (!optionalPlants.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Plants plants = optionalPlants.get();
        plants.setWater_Quota(updatedPlants.getWater_Quota());
        plants.setEmployee_quota(updatedPlants.getEmployee_quota());
        plants.setAge_Months(updatedPlants.getAge_Months());
        plants.setArea_quota_m(updatedPlants.getArea_quota_m());
        plants.setType(updatedPlants.getType());
        plants.setSoilQuality_quota(updatedPlants.getSoilQuality_quota());
        plants.setNutriments_quota(updatedPlants.getNutriments_quota());
        plants.setPrune_quota(updatedPlants.getPrune_quota());
        plants.setProject(updatedPlants.getProject());
        Plants savedPlants = plantsRepository.save(plants);
       //return ResponseEntity.ok(updatedPlants.getWater_Quota());
        return ResponseEntity.ok(savedPlants);
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


