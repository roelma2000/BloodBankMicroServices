package com.assignment4.bloodbankmicroserver.service;

import com.assignment4.bloodbankmicroserver.model.BloodStock;

import java.util.List;

public interface BloodStockService {
    List<BloodStock> getAllBloodStocks();
    BloodStock getBloodStockById(int id);
    BloodStock saveOrUpdateBloodStock(BloodStock bloodStock);
    void deleteBloodStock(int id);
}
