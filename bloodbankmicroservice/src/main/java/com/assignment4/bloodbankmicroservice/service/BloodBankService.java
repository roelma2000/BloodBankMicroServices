package com.assignment4.bloodbankmicroservice.service;

import com.assignment4.bloodbankmicroservice.model.BloodBank;
import java.util.List;

public interface BloodBankService {

    BloodBank saveBloodBank(BloodBank bloodBank);
    List<BloodBank> getAllBloodBanks();
    BloodBank getBloodBankById(Integer id);
    BloodBank updateBloodBank(BloodBank bloodBank, Integer id);
    void deleteBloodBank(Integer id);
}
