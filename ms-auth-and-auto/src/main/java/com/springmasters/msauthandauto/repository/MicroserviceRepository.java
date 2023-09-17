package com.springmasters.msauthandauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmasters.msauthandauto.model.Microservice;

public interface MicroserviceRepository extends JpaRepository<Microservice, Integer>{
    
}
