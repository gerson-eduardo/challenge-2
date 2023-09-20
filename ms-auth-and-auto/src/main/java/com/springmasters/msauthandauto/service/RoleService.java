package com.springmasters.msauthandauto.service;

import com.springmasters.msauthandauto.DTO.BindMsDTOReturn;
import com.springmasters.msauthandauto.DTO.RoleDTO;
import com.springmasters.msauthandauto.DTO.RoleWithUserDTO;
import com.springmasters.msauthandauto.DTO.Mapper.RoleMapper;
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
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
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

    public ResponseEntity<BindMsDTOReturn> bindUserMicroservice(Integer userId, Integer microserviceId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Microservice> microserviceOptional = microserviceRepository.findById(microserviceId);
        String error;

        if (userOptional.isEmpty()) {
            error = "User not found with ID: " + userId;
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error);
        }

        if (microserviceOptional.isEmpty()) {
            error = "Microservice not found with ID: " + microserviceId;
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, error);
        }

        User user = userOptional.get();
        Microservice microservice = microserviceOptional.get();

        if (!roleRepository.existsRoleByUserRoleAndMicroservice(user, microservice)) {
            Role role = new Role(user, microservice, Role.userRole.USER);
            roleRepository.save(role);
        } else{
            error = "user already linked to the microservice";
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, error);
        }

        BindMsDTOReturn bindDTO = new BindMsDTOReturn(user.getEmail(), microservice.getNameMicroservice());
        return ResponseEntity.ok(bindDTO);
    }

    public ResponseEntity<RoleDTO> findByUserAndMicrosservice(Integer userId, Integer microsserviceId){
        Optional<User> user = userRepository.findById(userId);
        Optional<Microservice> microsservice = microserviceRepository.findById(microsserviceId);

        if(user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found with ID: " + userId);
        if(microsservice.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Microsservice not found with ID: " + microsserviceId);
        
        Optional<Role> role = roleRepository.findByMicroserviceAndUserRole(microsservice.get(), user.get());
        if(role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user and microservice relationship was not found!");
        return ResponseEntity.ok(RoleMapper.INSTANCE.roleToRoleDTO(role.get()));
    }

    public ResponseEntity<List<RoleWithUserDTO>> findByMicrosservice(Integer idMicrosservice){
        if(microserviceRepository.findById(idMicrosservice).isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found Microsservice with id: ");
        List<RoleWithUserDTO> rolesDTO = new ArrayList<>();
        List<Role> roles = roleRepository.findByMicroservice(microserviceRepository.findById(idMicrosservice).get());
        for(Role role:roles){
            rolesDTO.add(RoleMapper.INSTANCE.roleToRoleWithUserDTO(role));
        }
        return ResponseEntity.ok(rolesDTO);
    }
}