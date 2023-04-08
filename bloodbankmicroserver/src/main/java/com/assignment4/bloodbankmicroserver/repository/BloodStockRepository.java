package com.assignment4.bloodbankmicroserver.repository;

import com.assignment4.bloodbankmicroserver.model.BloodStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodStockRepository extends JpaRepository<BloodStock,Integer> {
}
