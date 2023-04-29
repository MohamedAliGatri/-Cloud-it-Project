package com.cloudit.project.service;

import com.cloudit.project.ExeptionHnadler.PetsNotFoundExeption;
import com.cloudit.project.ExeptionHnadler.ProjectsNotFoundExeption;
import com.cloudit.project.Repository.PetsRepo;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetsService {
    private final PetsRepo pe_Repository;
@Autowired
    public PetsService(PetsRepo peRepository) {
        pe_Repository = peRepository;
    }
    public Pets addpets(Pets pet, Projects project) throws PetsNotFoundExeption {
        verifyPetNotExistInProject(pet, project);

        pet.setProject(project);
        return pe_Repository.save(pet);
    }

    // Méthode de vérification d'existence des animaux dans le projet
    private void verifyPetNotExistInProject(Pets pet, Projects project) throws PetsNotFoundExeption {
        // Vérifier si un animal avec le même identifiant existe déjà dans le projet
        if ( pe_Repository.existsById(pet.getId())) {
            throw new PetsNotFoundExeption("Animal already exists in the project.");
        }
        // Vérifier si un animal avec le même nom et type existe déjà dans le projet
      //  if (pe_Repository.isPetsAlreadyAssociatedWithAnotherProjects(pet.getId(), pet.getType(), project)) {
       //     throw new PetsNotFoundExeption("An animal with the same name and type already exists in the project.");
       // }
    }

    public List<Pets> findAllPets() {
        return pe_Repository.findAll();
    }

    public Pets updatePets(Pets Pet) {
        return pe_Repository.save(Pet);
    }

    public Pets findPetsById(Long id) {

        return (Pets) pe_Repository.findPetsById(id)
                .orElseThrow(() -> new PetsNotFoundExeption("project by id " + id + " was not found"));
    }



    public void deletePets(Long id){
        pe_Repository.deletePetsById(id);
    }

}
