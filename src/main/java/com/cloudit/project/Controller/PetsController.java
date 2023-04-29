package com.cloudit.project.Controller;


import com.cloudit.project.ExeptionHnadler.PetsNotFoundExeption;
import com.cloudit.project.Repository.PetsRepo;
import com.cloudit.project.Repository.ProjectsRepo;
import com.cloudit.project.model.Pets;
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

    @RequestMapping("/api/pets")
    public class PetsController {

        @Autowired
        private PetsRepo petsRepository;
    @Autowired
    private ProjectsRepo projectrepository;

        @GetMapping
        public List<Pets> getAllPets() {return petsRepository.findAll();
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

    @PostMapping("/Ajoutpets")
    public ResponseEntity<Object> create(@RequestBody Pets pet, @RequestParam long projectId) {
        try {
            //if (petsRepository.isPetsAlreadyAssociatedWithAnotherProjects(pet.getId(), pet.getType(), projectrepository.getOne(projectId))) {
               // throw new PetsNotFoundExeption("This pet already exists in the project");
           // }
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


