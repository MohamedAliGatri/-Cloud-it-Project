package com.cloudit.project.controller;

import com.cloudit.project.service.IAnnouncementService;

import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cloudit.project.model.Announcement;


import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Announcement")
public class AnnouncementController {

    private IAnnouncementService iAnnouncementService;

    @PostMapping("/add")
    public void add(@RequestBody Announcement announcement) {
        iAnnouncementService.add(announcement);
    }

    @PutMapping("/update")
    public Announcement update(@RequestBody Announcement announcement) {
        return iAnnouncementService.update(announcement);
    }

    @GetMapping("/all")
    public List<Announcement> getAll() {
        return iAnnouncementService.getAll();
    }

    @GetMapping("/get/{id}")
    public Announcement getById(@PathVariable long id) {
        return iAnnouncementService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable long id) {
        iAnnouncementService.remove(id);
    }

    @PostMapping("/file")
    @ResponseBody
    public Announcement uploadImg(@RequestParam("file") @Nullable MultipartFile file, @RequestParam("announcement") int idAnnouncement) {
        Announcement announcement = iAnnouncementService.getById(idAnnouncement);
        if (file == null) {
            announcement.setImage("defaultPic.jpg");
            iAnnouncementService.update(announcement);
        } else {
            try {
                File f = new File("C:\\upload\\" + "image" + idAnnouncement + file.getOriginalFilename());
                file.transferTo(f);
                announcement.setImage("image" + idAnnouncement + file.getOriginalFilename());
                iAnnouncementService.update(announcement);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return (announcement);

    }

    @GetMapping("/announcementNotApproved")
    public List<Announcement> findAnnouncementNotApproved() {
        return iAnnouncementService.findAnnouncementNotApproved();
    }
}