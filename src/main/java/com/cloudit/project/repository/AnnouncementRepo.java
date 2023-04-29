package com.cloudit.project.repository;

import com.cloudit.project.model.Announcement;

import com.cloudit.project.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnouncementRepo extends JpaRepository<Announcement,Long> {
    @Query(value = "SELECT * FROM event e WHERE e.approved='false'", nativeQuery = true)
    public List<Announcement> findAnnouncementNotApproved();
}
