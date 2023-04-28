package com.cloudit.project.service;
import com.cloudit.project.model.Contrat;
import com.cloudit.project.repository.ContratRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
public interface ContratServices {
    Contrat saveContrat(Contrat contrat);
    Contrat updateContrat(Contrat contrat);
    void deleteContrat(Contrat contrat);
    Contrat getContratById(Integer id_contrat);
    List<Contrat> getAllContrats();

}
