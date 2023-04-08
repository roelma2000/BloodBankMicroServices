package com.assignment4.bloodbankmicroserver.service;

import com.assignment4.bloodbankmicroserver.model.BloodStock;
import com.assignment4.bloodbankmicroserver.repository.BloodStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodStockServiceImpl implements BloodStockService {
    @Autowired
    private BloodStockRepository bloodStockRepository;

    @Override
    public List<BloodStock> getAllBloodStocks() {
        return bloodStockRepository.findAll();
    }

    @Override
    public BloodStock getBloodStockById(int id) {
        return bloodStockRepository.findById(id).orElse(null);
    }

    @Override
    public BloodStock saveOrUpdateBloodStock(BloodStock bloodStock) {
        return bloodStockRepository.save(bloodStock);
    }

    @Override
    public void deleteBloodStock(int id) {
        bloodStockRepository.deleteById(id);
    }
}
