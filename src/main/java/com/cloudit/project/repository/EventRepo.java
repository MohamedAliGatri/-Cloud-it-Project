package com.cloudit.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cloudit.project.model.Event;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event,Long>{

    @Query("SELECT e FROM Event e WHERE e.startDate > NOW()")
    List<Event> findUpcomingEvents();

    @Query(value = "SELECT * FROM event e WHERE NOW() > e.endDate and e.approved='true'", nativeQuery = true)
    public List<Event> findEventFinished();

    @Query(value = "SELECT * FROM event e WHERE e.approved='false'", nativeQuery = true)
    public List<Event> findEventNotApproved();

}
