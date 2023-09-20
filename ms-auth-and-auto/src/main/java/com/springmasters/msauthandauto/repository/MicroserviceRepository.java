package com.springmasters.msauthandauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmasters.msauthandauto.model.Microservice;
import java.util.List;
import java.util.Optional;


public interface MicroserviceRepository extends JpaRepository<Microservice, Integer>{
    Optional<List<Microservice>> findById(int id);
}
