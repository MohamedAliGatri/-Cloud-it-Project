package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Emergency;
import com.cloudit.project.repository.EmergencyRepo;
import com.cloudit.project.service.IEmergencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmergencyServiceImpl implements IEmergencyService {

    EmergencyRepo emergencyRepo;
    @Override
    public void add(Emergency emergency) {
        emergencyRepo.save(emergency);

    }

    @Override
    public Emergency update(Emergency emergency) {
        return emergencyRepo.save(emergency);
    }

    @Override
    public List<Emergency> getAll() {
        return emergencyRepo.findAll() ;
    }

    @Override
    public Emergency getById(long id) {
        return emergencyRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        emergencyRepo.deleteById(id);

    }
}
