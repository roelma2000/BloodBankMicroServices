package com.assignment4.bloodbankmicroserver.service;

import com.assignment4.bloodbankmicroserver.model.Seeker;

import java.util.List;

public interface SeekerService {
    List<Seeker> getAllSeekers();
    Seeker getSeekerById(int id);
    Seeker saveOrUpdateSeeker(Seeker seeker);
    void deleteSeeker(int id);
}
