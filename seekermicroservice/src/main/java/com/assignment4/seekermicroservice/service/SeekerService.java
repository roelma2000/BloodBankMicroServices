package com.assignment4.seekermicroservice.service;

import com.assignment4.seekermicroservice.model.Seeker;
import java.util.List;


public interface SeekerService {
    Seeker saveSeeker(Seeker seeker);
    List<Seeker> getAllSeekers();
    Seeker getSeekerById(Integer id);
    Seeker updateSeeker(Seeker seeker, Integer id);
    void deleteSeeker(Integer id);
}
