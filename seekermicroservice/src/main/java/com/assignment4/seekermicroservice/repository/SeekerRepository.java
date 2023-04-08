package com.assignment4.seekermicroservice.repository;
import com.assignment4.seekermicroservice.model.Seeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeekerRepository extends  JpaRepository<Seeker,Integer>{
}
