package com.cloudit.project.serviceImpl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.cloudit.project.model.Event;
import com.cloudit.project.repository.EventRepo;
import com.cloudit.project.service.IEventService;

import java.util.List;

@AllArgsConstructor
@Service
public class EventServiceImpl implements IEventService{
    EventRepo eventRepo;
    @Override
    public void add(Event event) {
        eventRepo.save(event);

    }

    @Override
    public Event update(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public List<Event> getAll() {
        return eventRepo.findAll() ;
    }

    @Override
    public Event getById(long id) {
        return eventRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        eventRepo.deleteById(id);

    }

    @Override
    public List<Event> findUpcomingEvents() {
        return eventRepo.findUpcomingEvents();
    }

    @Override
    public List<Event> findEventFinished() {
        return eventRepo.findEventFinished();
    }

    @Override
    public List<Event> findEventNotApproved() {
        return eventRepo.findEventNotApproved();
    }

}

