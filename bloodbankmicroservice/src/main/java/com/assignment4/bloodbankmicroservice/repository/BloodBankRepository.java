package com.assignment4.bloodbankmicroservice.repository;

import com.assignment4.bloodbankmicroservice.model.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodBankRepository extends JpaRepository<BloodBank,Integer> {
}
