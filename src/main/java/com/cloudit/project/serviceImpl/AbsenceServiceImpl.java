package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Absence;
import com.cloudit.project.Repository.AbsenceRepo;
import com.cloudit.project.service.AbsenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AbsenceServiceImpl implements AbsenceServices {
    @Autowired
    private AbsenceRepo absenceRepository;

    @Override
    public Absence saveAbsence(Absence absence) {
        if (absence.getDate_absence() == null) {
            throw new IllegalArgumentException("La date d'absence est obligatoire.");
        }
        return absenceRepository.save(absence);
    }

    @Override
    public Absence updateAbsence(Absence absence) {
        // Vérification que l'absence existe dans la base de données
        if (!absenceRepository.existsById(absence.getId_absence())) {
            throw new IllegalArgumentException("L'absence n'existe pas dans la base de données.");
        }
        return absenceRepository.save(absence);
    }

    @Override
    public void deleteAbsence(Absence absence) {
        // Vérification que l'absence existe dans la base de données
        if (!absenceRepository.existsById(absence.getId_absence())) {
            throw new IllegalArgumentException("L'absence n'existe pas dans la base de données.");
        }
        absenceRepository.delete(absence);
    }

    @Override
    public Absence getAbsenceById(Integer id_absence) {
        return absenceRepository.findById(id_absence)
                .orElseThrow(() -> new IllegalArgumentException("L'absence avec l'id " + id_absence + " n'existe pas."));
    }

    @Override
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }
}
