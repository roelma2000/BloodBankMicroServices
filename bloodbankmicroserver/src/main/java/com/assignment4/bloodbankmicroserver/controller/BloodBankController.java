package com.assignment4.bloodbankmicroserver.controller;

import com.assignment4.bloodbankmicroserver.model.BloodBank;
import com.assignment4.bloodbankmicroserver.service.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloodbanks")
public class BloodBankController {
    @Autowired
    private BloodBankService bloodBankService;

    @GetMapping
    public List<BloodBank> getAllBloodBanks() {
        return bloodBankService.getAllBloodBanks();
    }

    @GetMapping("/{id}")
    public BloodBank getBloodBankById(@PathVariable("id") int id) {
        return bloodBankService.getBloodBankById(id);
    }

    @PostMapping
    public BloodBank saveOrUpdateBloodBank(@RequestBody BloodBank bloodBank) {
        return bloodBankService.saveOrUpdateBloodBank(bloodBank);
    }

    @PutMapping
    public BloodBank updateBloodBank(@RequestBody BloodBank bloodBank) {
        return bloodBankService.saveOrUpdateBloodBank(bloodBank);
    }

    @DeleteMapping("/{id}")
    public void deleteBloodBank(@PathVariable("id") int id) {
        bloodBankService.deleteBloodBank(id);
    }
}
