package com.springmasters.msauthandauto.controller;

import com.springmasters.msauthandauto.DTO.BindMsDTOReturn;
import com.springmasters.msauthandauto.DTO.UserDTO;
import com.springmasters.msauthandauto.DTO.UserDTOReturn;
import com.springmasters.msauthandauto.model.User;
import com.springmasters.msauthandauto.service.RoleService;
import com.springmasters.msauthandauto.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springmasters.msauthandauto.repository.UserRepository;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/users/", consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTOReturn> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTOReturn> findById(@PathVariable int id){
        return userService.findById(id);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUserDTO() {
        return userService.getAll();
    }

    @PutMapping(value = "{id_user}/microsservice/{id_microsservice}")
    public ResponseEntity<BindMsDTOReturn> bindUserMicrosserice(@PathVariable Integer id_user, @PathVariable Integer id_microsservice) {
        return roleService.bindUserMicroservice(id_user, id_microsservice);
    }
    @Autowired
    private UserRepository userRepository;

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Integer id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);

        Map<String, String> responseMessage = new  HashMap<>();
        responseMessage.put("message", "User " + id + " successfully deleted.");

        return ResponseEntity.ok(responseMessage);
    }
}