package com.assignment4.bloodbankmicroserver.controller;

import com.assignment4.bloodbankmicroserver.model.Seeker;
import com.assignment4.bloodbankmicroserver.service.SeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seekers")
public class SeekerController {
    @Autowired
    private SeekerService seekerService;

    @GetMapping
    public List<Seeker> getAllSeekers() {
        return seekerService.getAllSeekers();
    }

    @GetMapping("/{id}")
    public Seeker getSeekerById(@PathVariable("id") int id) {
        return seekerService.getSeekerById(id);
    }

    @PostMapping
    public Seeker saveOrUpdateSeeker(@RequestBody Seeker seeker) {
        return seekerService.saveOrUpdateSeeker(seeker);
    }

    @PutMapping
    public Seeker updateSeeker(@RequestBody Seeker seeker) {
        return seekerService.saveOrUpdateSeeker(seeker);
    }

    @DeleteMapping("/{id}")
    public void deleteSeeker(@PathVariable("id") int id) {
        seekerService.deleteSeeker(id);
    }
}
