package com.cloudit.project.service;
import com.cloudit.project.model.Conge;

import java.util.List;
public interface congeServices {
    Conge saveConge(Conge conge);
    Conge updateConge(Conge conge);
    void deleteConge(Conge conge);
    Conge getCongeById(Integer id_cong);
    List<Conge> getAllConges();

}
