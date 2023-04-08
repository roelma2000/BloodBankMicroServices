package com.assignment4.bloodbankmicroserver.controller;

import com.assignment4.bloodbankmicroserver.model.BloodStock;
import com.assignment4.bloodbankmicroserver.service.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloodstocks")
public class BloodStockController {
    @Autowired
    private BloodStockService bloodStockService;

    @GetMapping
    public List<BloodStock> getAllBloodStocks() {
        return bloodStockService.getAllBloodStocks();
    }

    @GetMapping("/{id}")
    public BloodStock getBloodStockById(@PathVariable("id") int id) {
        return bloodStockService.getBloodStockById(id);
    }

    @PostMapping
    public BloodStock saveOrUpdateBloodStock(@RequestBody BloodStock bloodStock) {
        return bloodStockService.saveOrUpdateBloodStock(bloodStock);
    }

    @PutMapping
    public BloodStock updateBloodStock(@RequestBody BloodStock bloodStock) {
        return bloodStockService.saveOrUpdateBloodStock(bloodStock);
    }

    @DeleteMapping("/{id}")
    public void deleteBloodStock(@PathVariable("id") int id) {
        bloodStockService.deleteBloodStock(id);
    }
}
