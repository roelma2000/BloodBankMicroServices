package com.assignment4.bloodbankmicroservice.service;

import com.assignment4.bloodbankmicroservice.model.BloodBank;
import com.assignment4.bloodbankmicroservice.repository.BloodBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
@Service
public class BloodBankServiceImpl implements BloodBankService{
    @Autowired
    private BloodBankRepository bloodBankRepository;
    @Override
    public BloodBank saveBloodBank(BloodBank bloodBank) {
        return bloodBankRepository.save(bloodBank);
    }

    @Override
    public List<BloodBank> getAllBloodBanks() {
        return bloodBankRepository.findAll();
    }

    @Override
    public BloodBank getBloodBankById(Integer id) {
        return bloodBankRepository.findById(id).orElse(null);
    }

    @Override
    public BloodBank updateBloodBank(BloodBank bloodBank, Integer id) {
        BloodBank existingBloodBank = getBloodBankById(id);
        if(existingBloodBank != null){
                bloodBank.setBbnid(id);
                return bloodBankRepository.save(bloodBank);
        }
        return null;
    }

    @Override
    public void deleteBloodBank(Integer id) {
            bloodBankRepository.deleteById(id);
    }
}
