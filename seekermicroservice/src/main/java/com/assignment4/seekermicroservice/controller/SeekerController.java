package com.assignment4.seekermicroservice.controller;

import com.assignment4.seekermicroservice.model.Seeker;
import com.assignment4.seekermicroservice.service.SeekerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/seekers")
public class SeekerController {

    @Autowired
    private SeekerService seekerService;

    @PostMapping
    public ResponseEntity<Seeker> createSeeker(@RequestBody Seeker seeker) {
        return new ResponseEntity<>(seekerService.saveSeeker(seeker), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Seeker>> getAllSeekers() {
        return new ResponseEntity<>(seekerService.getAllSeekers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seeker> getSeekerById(@PathVariable("id") Integer id) {
        Seeker seeker = seekerService.getSeekerById(id);
        if (seeker != null) {
            return new ResponseEntity<>(seeker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seeker> updateSeeker(@PathVariable("id") Integer id, @RequestBody Seeker seeker) {
        Seeker updatedSeeker = seekerService.updateSeeker(seeker, id);
        if (updatedSeeker != null) {
            return new ResponseEntity<>(updatedSeeker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeeker(@PathVariable("id") Integer id) {
        seekerService.deleteSeeker(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
