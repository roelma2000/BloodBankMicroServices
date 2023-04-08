package com.assignment4.bloodbankmicroserver.service;

import com.assignment4.bloodbankmicroserver.model.BloodBank;
import com.assignment4.bloodbankmicroserver.repository.BloodBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodBankServiceImpl implements BloodBankService {
    @Autowired
    private BloodBankRepository bloodBankRepository;

    @Override
    public List<BloodBank> getAllBloodBanks() {
        return bloodBankRepository.findAll();
    }

    @Override
    public BloodBank getBloodBankById(int id) {
        return bloodBankRepository.findById(id).orElse(null);
    }

    @Override
    public BloodBank saveOrUpdateBloodBank(BloodBank bloodBank) {
        return bloodBankRepository.save(bloodBank);
    }

    @Override
    public void deleteBloodBank(int id) {
        bloodBankRepository.deleteById(id);
    }
}
