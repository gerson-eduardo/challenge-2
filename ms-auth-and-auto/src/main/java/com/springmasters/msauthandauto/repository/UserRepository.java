package com.springmasters.msauthandauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmasters.msauthandauto.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
