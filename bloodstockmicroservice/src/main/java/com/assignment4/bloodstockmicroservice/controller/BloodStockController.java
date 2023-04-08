package com.assignment4.bloodstockmicroservice.controller;

import com.assignment4.bloodstockmicroservice.model.BloodStock;
import com.assignment4.bloodstockmicroservice.service.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodstocks")
public class BloodStockController {
    @Autowired
    private BloodStockService bloodStockService;

    @PostMapping
    public ResponseEntity<BloodStock> createBloodStock(@RequestBody BloodStock bloodStock) {
        return new ResponseEntity<>(bloodStockService.createBloodStock(bloodStock), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloodStock> updateBloodStock(@PathVariable Integer id, @RequestBody BloodStock bloodStock) {
        return new ResponseEntity<>(bloodStockService.updateBloodStock(id,bloodStock), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodStock(@PathVariable Integer id) {
        bloodStockService.deleteBloodStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodStock> getBloodStockById(@PathVariable Integer id) {
        return new ResponseEntity<>(bloodStockService.getBloodStockById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BloodStock>> getAllBloodStocks() {
        return new ResponseEntity<>(bloodStockService.getAllBloodStocks(), HttpStatus.OK);
    }
}