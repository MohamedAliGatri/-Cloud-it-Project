package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Grade;
import com.cloudit.project.model.Poste;
import com.cloudit.project.Repository.PosteRepo;
import com.cloudit.project.service.PosteServices;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PosteServicelmpl implements PosteServices {
    @Autowired
    private PosteRepo posteRepository;

    @Override
    public Poste addPoste(Poste poste) {
        if(posteRepository.findByDesgPoste(poste.getDesgPoste()) != null) {
            throw new IllegalArgumentException("Le poste existe déjà");
        }

        return posteRepository.save(poste);
    }

    @Override
    public List<Poste> getAllPostes() {
        return posteRepository.findAll();
    }

    @Override
    public Poste getPosteById(Integer id) {
        return posteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Le poste n'existe pas"));
    }

    @Override
    public void deletePoste(Integer id) {
        posteRepository.deleteById(id);
    }
    @Override
    public Poste updatePoste(Integer id, Poste poste) {
        Poste gradeToUpdate = posteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Poste not found with id " + id));
        gradeToUpdate.setDesgPoste(poste.getDesgPoste());
        return posteRepository.save(gradeToUpdate);
    }
}
