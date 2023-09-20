package com.springmasters.msauthandauto.service;

import com.springmasters.msauthandauto.DTO.Mapper.UserMapper;
import com.springmasters.msauthandauto.DTO.UserDTO;
import com.springmasters.msauthandauto.DTO.UserDTOReturn;
import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.model.Role;
import com.springmasters.msauthandauto.model.User;
import com.springmasters.msauthandauto.model.Role.userRole;
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
public class UserService {
    private final UserRepository userRepository;
    private final MicroserviceRepository microserviceRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, MicroserviceRepository microserviceRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.microserviceRepository = microserviceRepository;
        this.roleRepository = roleRepository;
    }

    public ResponseEntity<UserDTOReturn> findById(int id){
        User user = userRepository.findById(id);
        UserDTOReturn userDTOReturn= UserMapper.INSTANCE.userToUserDTOReturn(user);
        return ResponseEntity.ok().body(userDTOReturn);
    }

    public ResponseEntity<UserDTOReturn> createUser(User user) {
        String error;
        if (userRepository.existsUserByEmail(user.getEmail())) {
            error = "email already registered in the system";
           throw new ResponseStatusException(HttpStatus.CONFLICT, error);
        } else {
            userRepository.save(user);
            UserDTOReturn userDTOReturn = UserMapper.INSTANCE.userToUserDTOReturn(user);
            return ResponseEntity.created(java.net.URI.create("")).body(userDTOReturn);
        }
    }

    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> allUser = userRepository.findAll();
        List<UserDTO> allUserDTO = new ArrayList<>();
        for (User user :
                allUser) {
            allUserDTO.add(UserMapper.INSTANCE.userToUserDTO(user));
        }
        return ResponseEntity.ok().body(allUserDTO);
    }


    public ResponseEntity<UserDTO> updateRoleAdmin(Integer idUser, Integer idMicrosservice){
        Optional<Microservice> microsservice = microserviceRepository.findById(idUser);
        Optional<User> user = userRepository.findById(idUser);

        if(microsservice.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not fount microsservice with id: " + idMicrosservice);
        if(microsservice.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not fount user with id: " + idUser);
        Optional<Role> role = roleRepository.findByMicroserviceAndUserRole(microsservice.get(), user.get());
        if(role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "not found user and microsservice realtship");
        if (role.get().getRoleUser().equals(userRole.USER)) {
            role.get().setRoleUser(userRole.ADMIN);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "User is a ADMIN");
        }
        roleRepository.save(role.get());
        user = userRepository.findById(idUser);
        return ResponseEntity.ok(UserMapper.INSTANCE.userToUserDTO(user.get()));
    }

    public ResponseEntity<UserDTO> updateRoleUser(Integer idUser, Integer idMicrosservice){
        Optional<Microservice> microsservice = microserviceRepository.findById(idUser);
        Optional<User> user = userRepository.findById(idUser);

        if(microsservice.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not fount microsservice with id: " + idMicrosservice);
        if(microsservice.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not fount user with id: " + idUser);
        Optional<Role> role = roleRepository.findByMicroserviceAndUserRole(microsservice.get(), user.get());
        if(role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "not found user and microsservice realtship");
        if (role.get().getRoleUser().equals(userRole.ADMIN)) {
            role.get().setRoleUser(userRole.USER);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "User is a USER");
        }
        roleRepository.save(role.get());
        user = userRepository.findById(idUser);
        return ResponseEntity.ok(UserMapper.INSTANCE.userToUserDTO(user.get()));
    }

    public ResponseEntity<Object> deleteUser(Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
