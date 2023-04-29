package com.cloudit.project.service;

import com.cloudit.project.model.Announcement;

import java.util.List;

public interface IAnnouncementService {

    void add(Announcement announcement);
    Announcement update(Announcement announcement);
    List<Announcement> getAll();
    Announcement getById(long id);
    void remove(long id);
    List<Announcement> findAnnouncementNotApproved ();
}
