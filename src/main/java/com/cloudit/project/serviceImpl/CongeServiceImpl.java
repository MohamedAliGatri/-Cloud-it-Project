package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Conge;
import com.cloudit.project.model.TypeConge;
import com.cloudit.project.Repository.CongeRepo;
import com.cloudit.project.service.congeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CongeServiceImpl implements congeServices {
    @Autowired
    private CongeRepo congeRepository;

    @Override
    public Conge saveConge(Conge conge) {
        if (conge.getDuree_cong() == null || conge.getDuree_cong().isEmpty()
                || conge.getDate_debutConge() == null || conge.getDate_finConge() == null
                || conge.getTypeConge() == null || conge.getEmploye() == null) {
            throw new IllegalArgumentException("Tous les champs obligatoires doivent être renseignés.");
        }

        if (conge.getTypeConge() == TypeConge.Arret) {
            if (conge.getDesg_arret() == null || conge.getDesg_arret().isEmpty()) {
                throw new IllegalArgumentException("Le champ desg_arret est obligatoire pour un congé de type 'Arret'.");
            }
        } else if (conge.getTypeConge() == TypeConge.Annuel) {
            if (conge.getAnnee_Conge() == null || conge.getSolde_conge() == null) {
                throw new IllegalArgumentException("Les champs annee_Conge et solde_conge sont obligatoires pour un congé de type 'Annuel'.");
            }
        } else if (conge.getTypeConge() == TypeConge.Exceptionnel) {
            if (conge.getAnnee_Conge_excep() == null || conge.getAnnee_Conge_excep().isEmpty()) {
                throw new IllegalArgumentException("Le champ annee_Conge_excep est obligatoire pour un congé de type 'Exceptionnel'.");
            }
        } else {
            throw new IllegalArgumentException("Le type de congé doit être 'Arret', 'Annuel' ou 'Exceptionnel'.");
        }

        return congeRepository.save(conge);
    }

    @Override
    public Conge updateConge(Conge conge) {
        // Vérification que le congé existe dans la base de données
        if (!congeRepository.existsById(conge.getId_cong())) {
            throw new IllegalArgumentException("Le congé n'existe pas dans la base de données.");
        }

        return congeRepository.save(conge);
    }

    @Override
    public void deleteConge(Conge conge) {
        // Vérification que le congé existe dans la base de données
        if (!congeRepository.existsById(conge.getId_cong())) {
            throw new IllegalArgumentException("Le congé n'existe pas dans la base de données.");
        }

        congeRepository.delete(conge);
    }
    @Override
    public Conge getCongeById(Integer id_cong) {
        return congeRepository.findById(id_cong)
                .orElseThrow(() -> new IllegalArgumentException("Le congé avec l'id " + id_cong + " n'existe pas."));
    }
    @Override
    public List<Conge> getAllConges() {
        return congeRepository.findAll();
    }
}
