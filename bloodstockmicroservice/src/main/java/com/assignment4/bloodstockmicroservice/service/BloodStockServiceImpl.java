package com.assignment4.bloodstockmicroservice.service;

import com.assignment4.bloodstockmicroservice.model.BloodStock;
import com.assignment4.bloodstockmicroservice.repository.BloodStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodStockServiceImpl implements BloodStockService {
    @Autowired
    private BloodStockRepository bloodStockRepository;

    @Override
    public BloodStock createBloodStock(BloodStock bloodStock) {
        return bloodStockRepository.save(bloodStock);
    }

    @Override
    public BloodStock updateBloodStock(Integer id, BloodStock bloodStock) {
        BloodStock existingStock = getBloodStockById(id);
        if(existingStock != null){
            bloodStock.setBsid(id);
            return bloodStockRepository.save(bloodStock);
        }
        return null;
    }

    @Override
    public void deleteBloodStock(Integer id) {
        bloodStockRepository.deleteById(id);
    }

    @Override
    public BloodStock getBloodStockById(Integer id) {
        return bloodStockRepository.findById(id).orElse(null);
    }

    @Override
    public List<BloodStock> getAllBloodStocks() {
        return bloodStockRepository.findAll();
    }
}