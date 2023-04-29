package com.cloudit.project.controller;

import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.cloudit.project.model.Event;
import com.cloudit.project.service.IEventService;

import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/Event")
public class EventController {
    private IEventService iEventService;

    @PostMapping("/add")
    public void add(@RequestBody Event event) {
        iEventService.add(event);
    }

    @PutMapping("/update")
    public Event update(@RequestBody Event event) {
        return iEventService.update(event);
    }

    @GetMapping("/all")
    public List<Event> getAll() {
        return iEventService.getAll();
    }

    @GetMapping("/get/{id}")
    public Event getById(@PathVariable long id) {
        return iEventService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable long id) {
        iEventService.remove(id);
    }

    @PostMapping("/file")
    @ResponseBody
    public Event  uploadImg (@RequestParam("file") @Nullable MultipartFile file , @RequestParam("event") int idEvent ) {
        Event event =iEventService.getById(idEvent);
        if(file==null) {
            event.setImage("defaultPic.jpg");
            iEventService.update(event);
        }else {
            try {
                File f = new File("C:\\upload\\" +"image" + idEvent+file.getOriginalFilename());
                file.transferTo(f);
                event.setImage("image"+idEvent+file.getOriginalFilename());
                iEventService.update(event);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return(event);
    }

    @GetMapping("/upcomingEvents")
    public List<Event> findUpcomingEvents() {
        return iEventService.findUpcomingEvents();
    }

    @GetMapping("/eventFinished")
    public List<Event> findEventFinished() {
        return iEventService.findEventFinished();
    }

    @GetMapping("/eventNotApproved")
    public List<Event> findEventNotApproved() {
        return iEventService.findEventNotApproved();
    }


}
