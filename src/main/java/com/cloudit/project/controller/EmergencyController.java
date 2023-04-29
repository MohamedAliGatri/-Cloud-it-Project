package com.cloudit.project.controller;

import com.cloudit.project.model.Emergency;
import com.cloudit.project.service.IEmergencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/Emergency")

public class EmergencyController {

    private IEmergencyService iEmergencyService;

    @PostMapping("/add")
    public void add(@RequestBody Emergency emergency) {iEmergencyService.add(emergency);}

    @PutMapping("/update")
    public Emergency update(@RequestBody Emergency emergency) {
        return iEmergencyService.update(emergency);
    }

    @GetMapping("/all")
    public List<Emergency> getAll() {
        return iEmergencyService.getAll();
    }

    @GetMapping("/get/{id}")
    public Emergency getById(@PathVariable long id) {
        return iEmergencyService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable long id) {
        iEmergencyService.remove(id);
    }

}
