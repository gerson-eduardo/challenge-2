package com.springmasters.msauthandauto.repository;

import com.springmasters.msauthandauto.DTO.UserDTOReturn;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springmasters.msauthandauto.model.User;
import org.springframework.http.ResponseEntity;

public interface UserRepository extends JpaRepository<User, Integer>{
    Boolean existsUserByEmail(String email);

    User findById(int id);
}
