package com.cloudit.project.Controller;


import com.cloudit.project.Repository.PetsRepo;
import com.cloudit.project.model.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/pets")
    public class PetsController {

        @Autowired
        private PetsRepo petsRepository;

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


