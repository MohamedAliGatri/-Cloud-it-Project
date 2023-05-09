package com.cloudit.project.Controller;


import com.cloudit.project.ExeptionHnadler.PetsNotFoundExeption;
import com.cloudit.project.ExeptionHnadler.ProjectsNotFoundExeption;
import com.cloudit.project.Repository.PetsRepo;
import com.cloudit.project.Repository.ProjectsRepo;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Plants;
import com.cloudit.project.model.Projects;
import jakarta.transaction.Transactional;
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

    @RequestMapping("/api/pets")
    public class PetsController {

        @Autowired
        private PetsRepo petsRepository;
    @Autowired
    private ProjectsRepo projectrepository;

        @GetMapping
        public List<Pets> getAllPets() {return petsRepository.findAll();
        }
    @PostMapping("/affectpet/{projectId}")
    public ResponseEntity<Object> create(@RequestBody Pets pet, @PathVariable long projectId) {

        pet.setProject(projectrepository.findProjectsById(projectId));
        if ((projectrepository.findProjectsById(projectId))==null) {
            throw new ProjectsNotFoundExeption("ce projet n'existe pas veuillez creér un");
        }
        Pets savedPlant = petsRepository.save(pet);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlant);


    }
        @GetMapping("/{id}")
        public ResponseEntity<Pets> getPetById(@PathVariable Long id) {
            Optional<Pets> pet = petsRepository.findById(id);
            if (pet.isPresent()) {
                return ResponseEntity.ok(pet.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    @GetMapping("/petid/{id}")
    public ResponseEntity<Pets> getPlantById(@PathVariable Long id) {
        Pets  pet = petsRepository.findById(id).get();
        if ((pet)==null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(pet);

        }
    }

    @GetMapping("/projet/{id}")
    public ResponseEntity<List<Pets>> getPetofprojectById(@PathVariable Long id) {
        List<Pets> pet = petsRepository.findByIdprojet(id);
        if (pet.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(pet);

        }
    }
    //@Modifying
    //@Transactional
   // @PutMapping("/update")
   // public ResponseEntity<Pets> updatePlant(@RequestBody Pets pet) {
     //   Pets updatedPet = petsRepository.save(pet);
       // return ResponseEntity.ok(updatedPet);
    //}
    @Modifying
    @Transactional
    @PutMapping("/update")
    public ResponseEntity<Pets> updatePlants( @RequestBody Pets updatedPets) {
        Optional<Pets> optionalPets = petsRepository.findById(updatedPets.getId());
        if (!optionalPets.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Pets pet = optionalPets.get();
        System.out.println(updatedPets.getWater_Quota());
        pet.setWater_Quota(updatedPets.getWater_Quota());
        pet.setEmployee_quota(updatedPets.getEmployee_quota());
        pet.setAge_Months(updatedPets.getAge_Months());
        pet.setArea_quota_m(updatedPets.getArea_quota_m());
        pet.setType(updatedPets.getType());
        pet.setShelter_quota(updatedPets.getShelter_quota());
        pet.setWeights(updatedPets.getWeights());
        pet.setProject(updatedPets.getProject());
        Pets savedPets = petsRepository.save(pet);
        //return ResponseEntity.ok(updatedPlants.getWater_Quota());
        return ResponseEntity.ok(savedPets);
    }


    @PostMapping("/Ajoutpets")
    public ResponseEntity<Object> createe(@RequestBody Pets pet, @RequestParam long projectId) {
        try {
            if (petsRepository.isPetsAlreadyAssociatedWithAnotherProjects(pet.getId(), pet.getType(), projectrepository.getOne(projectId))) {
                throw new PetsNotFoundExeption("This pet already exists in the project");
            }
            Projects project = projectrepository.getOne(projectId);
            pet.setProject(project);
            Pets savedPet = petsRepository.save(pet);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedPet.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (PetsNotFoundExeption ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


        @PostMapping("/")
        public Pets createPet(@RequestBody Pets pet) {
            return petsRepository.save(pet);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Pets> updatePet(@PathVariable Long id, @RequestBody Pets petDetails) {
            Optional<Pets> pet = petsRepository.findById(id);
            if (pet.isPresent()) {
                Pets updatedPet = pet.get();
                updatedPet.setType(petDetails.getType());
                updatedPet.setWeights(petDetails.getWeights());
                updatedPet.setShelter_quota(petDetails.getShelter_quota());
                updatedPet.setProject(petDetails.getProject());
                return ResponseEntity.ok(petsRepository.save(updatedPet));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity deletePet(@PathVariable Long id) {
            Optional<Pets> pet = petsRepository.findById(id);
            if (pet.isPresent()) {
                petsRepository.delete(pet.get());
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }


