package com.springmasters.msauthandauto.repository;

import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springmasters.msauthandauto.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
     Boolean existsRoleByUserRoleAndMicroservice(User userRole, Microservice microservice);
}
