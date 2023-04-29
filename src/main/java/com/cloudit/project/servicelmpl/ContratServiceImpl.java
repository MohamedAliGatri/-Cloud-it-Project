package com.cloudit.project.servicelmpl;

import com.cloudit.project.model.Contrat;
import com.cloudit.project.repository.ContratRepo;
import com.cloudit.project.service.ContratServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratServices {
    @Autowired
    private ContratRepo contratRepository;

    @Override
    public Contrat saveContrat(Contrat contrat) {
        if (contrat.getType_contrat() == null || contrat.getDate_debut_cont() == null) {
            throw new IllegalArgumentException("Les champs type_contrat et date_debut_cont sont obligatoires.");
        }
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        // Vérification que le contrat existe dans la base de données
        if (!contratRepository.existsById(contrat.getId_contrat())) {
            throw new IllegalArgumentException("Le contrat n'existe pas dans la base de données.");
        }
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(Contrat contrat) {
        // Vérification que le contrat existe dans la base de données
        if (!contratRepository.existsById(contrat.getId_contrat())) {
            throw new IllegalArgumentException("Le contrat n'existe pas dans la base de données.");
        }
        contratRepository.delete(contrat);
    }

    @Override
    public Contrat getContratById(Integer id_contrat) {
        return contratRepository.findById(id_contrat)
                .orElseThrow(() -> new IllegalArgumentException("Le contrat avec l'id " + id_contrat + " n'existe pas."));
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }
}
