package com.springmasters.msauthandauto.service;

import com.springmasters.msauthandauto.DTO.BindMsDTOReturn;
import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.model.Role;
import com.springmasters.msauthandauto.model.User;
import com.springmasters.msauthandauto.repository.MicroserviceRepository;
import com.springmasters.msauthandauto.repository.RoleRepository;
import com.springmasters.msauthandauto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    private final UserRepository userRepository;
    private final MicroserviceRepository microserviceRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(UserRepository userRepository, MicroserviceRepository microserviceRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.microserviceRepository = microserviceRepository;
        this.roleRepository = roleRepository;
    }

    public ResponseEntity<Object> bindUserMicroservice(Integer userId, Integer microserviceId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Microservice> microserviceOptional = microserviceRepository.findById(microserviceId);

        if (userOptional.isEmpty()) {
            return createNotFoundResponse("User not found with ID: " + userId);
        }

        if (microserviceOptional.isEmpty()) {
            return createNotFoundResponse("Microservice not found with ID: " + microserviceId);
        }

        User user = userOptional.get();
        Microservice microservice = microserviceOptional.get();

        if (!roleRepository.existsRoleByUserRoleAndMicroservice(user, microservice)) {
            Role role = new Role(user, microservice, Role.userRole.USER);
            roleRepository.save(role);
        }

        BindMsDTOReturn bindDTO = new BindMsDTOReturn(user.getEmail(), microservice.getNameMicroservice());
        return ResponseEntity.ok(bindDTO);
    }

    private ResponseEntity<Object> createNotFoundResponse(String errorMessage) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}