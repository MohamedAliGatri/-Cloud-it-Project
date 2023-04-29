package com.cloudit.project.service;
import com.cloudit.project.model.Contrat;

import java.util.List;
public interface ContratServices {
    Contrat saveContrat(Contrat contrat);
    Contrat updateContrat(Contrat contrat);
    void deleteContrat(Contrat contrat);
    Contrat getContratById(Integer id_contrat);
    List<Contrat> getAllContrats();

}
