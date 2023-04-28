package com.cloudit.project.servicelmpl;

import com.cloudit.project.model.Conge;
import com.cloudit.project.model.Contrat;
import com.cloudit.project.model.Employe;
import com.cloudit.project.repository.*;
import com.cloudit.project.service.EmployeServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeServicelmpl implements EmployeServices {
    @Autowired
    private EmployeRepo employeRepository;

    @Autowired
    private ContratRepo contratRepository;

    @Autowired
    private GradeRepo gradeRepository;

    @Autowired
    private PieceIdentiteRepo pieceIdentiteRepository;
    @Autowired
    private AbsenceRepo absenceRepository;
    private CongeRepo congeRepository;

    @Override
    public Employe saveEmploye(Employe employe) {
        if (employe == null) {
            throw new IllegalArgumentException("Employe cannot be null.");
        }
        if (employe.getNom_emp() == null || employe.getNom_emp().trim().isEmpty()) {
            throw new IllegalArgumentException("Employe nom_emp cannot be null or empty.");
        }
        if (employe.getPrenom_emp() == null || employe.getPrenom_emp().trim().isEmpty()) {
            throw new IllegalArgumentException("Employe prenom_emp cannot be null or empty.");
        }
        if (employe.getDns_emp() == null) {
            throw new IllegalArgumentException("Employe dns_emp cannot be null.");
        }
        if (employe.getLieu_ns_emp() == null || employe.getLieu_ns_emp().trim().isEmpty()) {
            throw new IllegalArgumentException("Employe lieu_ns_emp cannot be null or empty.");
        }
        if (employe.getAdresse_emp() == null || employe.getAdresse_emp().trim().isEmpty()) {
            throw new IllegalArgumentException("Employe adresse_emp cannot be null or empty.");
        }
        if (employe.getNum_tel_emp() == null || employe.getNum_tel_emp() <= 0) {
            throw new IllegalArgumentException("Employe num_tel_emp cannot be null or negative.");
        }
        if (employe.getNum_ss_emp() == null || employe.getNum_ss_emp() <= 0) {
            throw new IllegalArgumentException("Employe num_ss_emp cannot be null or negative.");
        }
        if (employe.getNum_cb_emp() == null || employe.getNum_cb_emp() <= 0) {
            throw new IllegalArgumentException("Employe num_cb_emp cannot be null or negative.");
        }
        if (employe.getContrat() == null) {
            throw new IllegalArgumentException("Employe contrat cannot be null.");
        }
        if (employe.getGrade() == null) {
            throw new IllegalArgumentException("Employe grade cannot be null.");
        }
        if (employe.getPostes() == null || employe.getPostes().isEmpty()) {
            throw new IllegalArgumentException("Employe postes cannot be null or empty.");
        }
        if (employe.getPieceIdentite() == null) {
            throw new IllegalArgumentException("Employe pieceIdentite cannot be null.");
        }

        return employeRepository.save(employe);
    }
    @Override
    public Employe updateEmploye(Employe employe) {
        if (employe == null || employe.getMat_emp() == null) {
            throw new IllegalArgumentException("Employe and matricule must not be null.");
        }

        Employe existingEmploye = employeRepository.findById(employe.getMat_emp())
                .orElseThrow(() -> new EntityNotFoundException("Employe with matricule " + employe.getMat_emp() + " not found."));

        if (employe.getCivilite_emp() != null) {
            existingEmploye.setCivilite_emp(employe.getCivilite_emp());
        }
        if (employe.getSituation_fam_emp() != null) {
            existingEmploye.setSituation_fam_emp(employe.getSituation_fam_emp());
        }
        if (employe.getNom_emp() != null) {
            existingEmploye.setNom_emp(employe.getNom_emp());
        }
        if (employe.getPrenom_emp() != null) {
            existingEmploye.setPrenom_emp(employe.getPrenom_emp());
        }
        if (employe.getDns_emp() != null) {
            existingEmploye.setDns_emp(employe.getDns_emp());
        }
        if (employe.getLieu_ns_emp() != null) {
            existingEmploye.setLieu_ns_emp(employe.getLieu_ns_emp());
        }
        if (employe.getAdresse_emp() != null) {
            existingEmploye.setAdresse_emp(employe.getAdresse_emp());
        }
        if (employe.getNum_tel_emp() != null) {
            existingEmploye.setNum_tel_emp(employe.getNum_tel_emp());
        }
        if (employe.getNum_ss_emp() != null) {
            existingEmploye.setNum_ss_emp(employe.getNum_ss_emp());
        }
        if (employe.getNum_cb_emp() != null) {
            existingEmploye.setNum_cb_emp(employe.getNum_cb_emp());
        }
        if (employe.getContrat() != null) {
            existingEmploye.setContrat(employe.getContrat());
        }
        if (employe.getGrade() != null) {
            existingEmploye.setGrade(employe.getGrade());
        }

        if (employe.getPostes() != null) {
            existingEmploye.getPostes().clear();
            existingEmploye.getPostes().addAll(employe.getPostes());
        }

        return employeRepository.save(existingEmploye);
    }
    @Override
    public void deleteEmploye(Integer mat_emp) {
        Optional<Employe> employe = employeRepository.findById(mat_emp);
        if (employe.isPresent()) {
            Employe e = employe.get();

            if (e.getPieceIdentite() != null) {
                pieceIdentiteRepository.delete(e.getPieceIdentite());
            }
            if (e.getAbsence() != null) {
                absenceRepository.delete(e.getAbsence());
            }
            if (e.getConge() != null) {
                for (Conge c : e.getConge()) {
                    congeRepository.delete(c);
                }
            }
            if (e.getPostes() != null) {
                e.getPostes().clear();
            }
            employeRepository.delete(e);
        } else {
            throw new EntityNotFoundException("L'employé avec le matricule " + mat_emp + " n'existe pas.");
        }
    }
    @Override
    public Employe getEmployeById(Integer mat_emp) {
        Optional<Employe> optionalEmploye = employeRepository.findById(mat_emp);
        if (optionalEmploye.isPresent()) {
            return optionalEmploye.get();
        } else {
            throw new NoSuchElementException("Employe with id " + mat_emp + " does not exist");
        }
    }
    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

}
