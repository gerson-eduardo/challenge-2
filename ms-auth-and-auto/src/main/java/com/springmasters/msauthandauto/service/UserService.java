package com.springmasters.msauthandauto.service;

import com.springmasters.msauthandauto.DTO.Mapper.UserMapper;
import com.springmasters.msauthandauto.DTO.UserDTO;
import com.springmasters.msauthandauto.model.User;
import com.springmasters.msauthandauto.repository.MicroserviceRepository;
import com.springmasters.msauthandauto.repository.RoleRepository;
import com.springmasters.msauthandauto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public User createUser(User user) {
        if (userRepository.existsUserByEmail(user.getEmail())) {
            return null;
        } else {
            return userRepository.save(user);
        }
    }

    public List<UserDTO> getAllUser() {
        List<User> allUser = userRepository.findAll();
        List<UserDTO> allUserDTO = new ArrayList<>();
        for (User user :
                allUser) {
            allUserDTO.add(UserMapper.INSTANCE.userToUserDTO(user));
        }
        return allUserDTO;
    }


}
