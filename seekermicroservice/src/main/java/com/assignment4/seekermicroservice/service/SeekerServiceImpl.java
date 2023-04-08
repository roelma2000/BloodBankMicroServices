package com.assignment4.seekermicroservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment4.seekermicroservice.model.Seeker;
import com.assignment4.seekermicroservice.repository.SeekerRepository;

@Service
public class SeekerServiceImpl implements SeekerService {

    @Autowired
    private SeekerRepository seekerRepository;

    @Override
    public Seeker saveSeeker(Seeker seeker) {
        return seekerRepository.save(seeker);
    }

    @Override
    public List<Seeker> getAllSeekers() {
        return seekerRepository.findAll();
    }

    @Override
    public Seeker getSeekerById(Integer id) {
        return seekerRepository.findById(id).orElse(null);
    }

    @Override
    public Seeker updateSeeker(Seeker seeker, Integer id) {
        Seeker existingSeeker = getSeekerById(id);
        if (existingSeeker != null) {
            seeker.setSeekerId(id);
            return seekerRepository.save(seeker);
        }
        return null;
    }

    @Override
    public void deleteSeeker(Integer id) {
        seekerRepository.deleteById(id);
    }
}
