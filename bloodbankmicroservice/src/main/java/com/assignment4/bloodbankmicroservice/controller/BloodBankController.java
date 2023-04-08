package com.assignment4.bloodbankmicroservice.controller;

import com.assignment4.bloodbankmicroservice.model.BloodBank;
import com.assignment4.bloodbankmicroservice.repository.BloodBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodbanks")
public class BloodBankController {

    @Autowired
    private BloodBankRepository bloodBankRepository;

    @GetMapping
    public ResponseEntity<List<BloodBank>> getAllBloodBanks() {
        return new ResponseEntity<>(bloodBankRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodBank> getBloodBankById(@PathVariable Integer id) {
        return bloodBankRepository.findById(id)
                .map(bloodBank -> new ResponseEntity<>(bloodBank, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BloodBank> createBloodBank(@RequestBody BloodBank bloodBank) {
        return new ResponseEntity<>(bloodBankRepository.save(bloodBank), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloodBank> updateBloodBank(@PathVariable Integer id, @RequestBody BloodBank bloodBank) {
        BloodBank existingBloodBank = bloodBankRepository.findById(id).orElse(null);
        if (existingBloodBank != null) {
            bloodBank.setBbnid(existingBloodBank.getBbnid());
            return new ResponseEntity<>(bloodBankRepository.save(bloodBank), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodBank(@PathVariable Integer id) {
        if (bloodBankRepository.existsById(id)) {
            bloodBankRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
