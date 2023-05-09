package com.cloudit.project.service;

import com.cloudit.project.model.Poste;

import java.util.List;

public interface PosteServices {
    Poste addPoste(Poste poste);
    List<Poste> getAllPostes();
    Poste getPosteById(Integer id);
    void deletePoste(Integer id);
    Poste updatePoste(Integer id,Poste poste);
}
