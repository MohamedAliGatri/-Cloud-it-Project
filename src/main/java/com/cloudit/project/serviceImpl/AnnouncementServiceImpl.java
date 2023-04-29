package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Announcement;
import com.cloudit.project.repository.AnnouncementRepo;
import com.cloudit.project.service.IAnnouncementService;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AnnouncementServiceImpl implements IAnnouncementService {

    AnnouncementRepo announcementRepo;
    @Override
    public void add(Announcement announcement) {
        announcementRepo.save(announcement);

    }

    @Override
    public Announcement update(Announcement announcement) {
        return announcementRepo.save(announcement);
    }

    @Override
    public List<Announcement> getAll() {
        return announcementRepo.findAll() ;
    }

    @Override
    public Announcement getById(long id) {
        return announcementRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        announcementRepo.deleteById(id);

    }
    @Override
    public List<Announcement> findAnnouncementNotApproved() {
        return announcementRepo.findAnnouncementNotApproved();
    }
}
