package com.assignment4.bloodbankmicroserver.service;

import com.assignment4.bloodbankmicroserver.model.BloodBank;

import java.util.List;

public interface BloodBankService {
    List<BloodBank> getAllBloodBanks();
    BloodBank getBloodBankById(int id);
    BloodBank saveOrUpdateBloodBank(BloodBank bloodBank);
    void deleteBloodBank(int id);
}
