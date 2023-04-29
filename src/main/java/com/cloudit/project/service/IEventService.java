package com.cloudit.project.service;

import com.cloudit.project.model.Event;
import java.util.List;

public interface IEventService {

    void add(Event event);
    Event update(Event event);
    List<Event> getAll();
    Event getById(long id);
    void remove(long id);
    List<Event> findUpcomingEvents ();

    List<Event> findEventFinished ();

    List<Event> findEventNotApproved ();
}
