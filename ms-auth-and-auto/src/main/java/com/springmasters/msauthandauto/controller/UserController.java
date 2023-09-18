package com.springmasters.msauthandauto.controller;

import com.springmasters.msauthandauto.DTO.Mapper.UserMapper;
import com.springmasters.msauthandauto.DTO.UserDTO;
import com.springmasters.msauthandauto.DTO.UserDTOReturn;
import com.springmasters.msauthandauto.model.User;
import com.springmasters.msauthandauto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/users/", consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTOReturn> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        if (newUser != null) {
            UserDTOReturn dto = UserMapper.INSTANCE.userToUserDTOReturn(user);
            return ResponseEntity.created(java.net.URI.create("")).body(dto);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping
    public List<UserDTO> getAllUserDTO() {
        return userService.getAllUser();
    }
}
