package com.springmasters.msauthandauto.ServiceTests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import com.springmasters.msauthandauto.DTO.UserDTO;
import com.springmasters.msauthandauto.DTO.UserDTOReturn;
import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.model.Role;
import com.springmasters.msauthandauto.model.User;
import com.springmasters.msauthandauto.model.Role.userRole;
import com.springmasters.msauthandauto.repository.MicroserviceRepository;
import com.springmasters.msauthandauto.repository.RoleRepository;
import com.springmasters.msauthandauto.repository.UserRepository;
import com.springmasters.msauthandauto.service.UserService;

public class UserServiceTest {

    private UserRepository userRepository;
    private MicroserviceRepository microserviceRepository;
    private RoleRepository roleRepository;
    private UserService userService;
    private User user1;
    private User user2;
    List<Role> roles, roles2;
    Role role, role2,role3; 

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
        microserviceRepository = mock(MicroserviceRepository.class);
        roleRepository = mock(RoleRepository.class);
        userService = new UserService(userRepository, microserviceRepository, roleRepository);
        // Mock data for UserRepository
        user1 = new User();
        user1.setName("User1");
        user2 = new User();
        user2.setName("User2");
        roles = new ArrayList<>();       
        roles2 = new ArrayList<>();
        role = new Role(1,user1, new Microservice("Microsservice A"), userRole.USER);
        role2 = new Role(2,user1, new Microservice("Microsservice B"), userRole.USER);
        role3 = new Role(3,user2, new Microservice("Microsservice B"), userRole.USER);
        roles.add(role);        
        roles.add(role2);
        roles2.add(role3);
        user1.setUserRoles(roles);
        user2.setUserRoles(roles2);
    }

    @Test
    public void testCreateUserSuccess() {
        User newUser = new User();
        newUser.setEmail("test@example.com");

        when(userRepository.existsUserByEmail(newUser.getEmail())).thenReturn(false);

        ResponseEntity<UserDTOReturn> response = userService.createUser(newUser);

        assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Expected status code does not match returned status code");
    }

    @Test
    public void testCreateUserConflict() {
        User existingUser = new User();
        existingUser.setEmail("test@example.com");

        when(userRepository.existsUserByEmail(existingUser.getEmail())).thenReturn(true);

        try {
            userService.createUser(existingUser);
            fail("Expected ResponseStatusException was not thrown.");
        } catch (ResponseStatusException e) {
            assertEquals(HttpStatus.CONFLICT, e.getStatusCode(), "Expected status code does not match returned status code");
        }
    }

    @Test
    public void testGetAllUsers() {

        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        ResponseEntity<List<UserDTO>> response = userService.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected status code does not match returned status code");
        assertEquals(2, response.getBody().size(), "Expected list size does not match returned list size");
    }
}
