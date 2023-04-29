package com.cloudit.project.service;

import com.cloudit.project.model.Emergency;

import java.util.List;

public interface IEmergencyService {

    void add(Emergency emergency);
    Emergency update(Emergency emergency);
    List<Emergency> getAll();
    Emergency getById(long id);
    void remove(long id);
}
