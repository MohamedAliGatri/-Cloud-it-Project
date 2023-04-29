package com.cloudit.project.service;

import com.cloudit.project.ExeptionHnadler.PetsNotFoundExeption;
import com.cloudit.project.ExeptionHnadler.ProjectsNotFoundExeption;
import com.cloudit.project.Repository.PetsRepo;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsService {
    private final PetsRepo pe_Repository;
@Autowired
    public PetsService(PetsRepo peRepository) {
        pe_Repository = peRepository;
    }
    public Pets addPets(Pets Pet) {

        return pe_Repository.save(Pet);
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
