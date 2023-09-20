package com.springmasters.msauthandauto.repository;

import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springmasters.msauthandauto.model.Role;
import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Integer>{
     Boolean existsRoleByUserRoleAndMicroservice(User userRole, Microservice microservice);

     Optional<Role> findByMicroserviceAndUserRole(Microservice microservice, User userRole);
}
