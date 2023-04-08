package com.assignment4.bloodbankmicroserver.service;

import com.assignment4.bloodbankmicroserver.model.Seeker;
import com.assignment4.bloodbankmicroserver.repository.SeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeekerServiceImpl implements SeekerService {
    @Autowired
    private SeekerRepository seekerRepository;

    @Override
    public List<Seeker> getAllSeekers() {
        return seekerRepository.findAll();
    }

    @Override
    public Seeker getSeekerById(int id) {
        return seekerRepository.findById(id).orElse(null);
    }

    @Override
    public Seeker saveOrUpdateSeeker(Seeker seeker) {
        return seekerRepository.save(seeker);
    }

    @Override
    public void deleteSeeker(int id) {
        seekerRepository.deleteById(id);
    }
}

