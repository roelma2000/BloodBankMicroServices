package com.assignment4.bloodbankmicroserver.repository;

import com.assignment4.bloodbankmicroserver.model.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodBankRepository extends JpaRepository<BloodBank,Integer> {
}
