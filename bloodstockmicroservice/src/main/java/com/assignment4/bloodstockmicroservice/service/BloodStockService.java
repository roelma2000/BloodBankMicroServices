package com.assignment4.bloodstockmicroservice.service;

import com.assignment4.bloodstockmicroservice.model.BloodStock;

import java.util.List;

public interface BloodStockService {
    BloodStock createBloodStock(BloodStock bloodStock);
    BloodStock updateBloodStock(Integer id, BloodStock bloodStock);
    void deleteBloodStock(Integer id);
    BloodStock getBloodStockById(Integer id);
    List<BloodStock> getAllBloodStocks();
}