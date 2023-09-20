package com.springmasters.msauthandauto.MapperTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.springmasters.msauthandauto.DTO.UserDTO;
import com.springmasters.msauthandauto.DTO.UserDTOReturn;
import com.springmasters.msauthandauto.DTO.Mapper.UserMapper;
import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.model.Role;
import com.springmasters.msauthandauto.model.User;

@SpringBootTest
public class UserMapperTest {
    private User user;

@BeforeEach
public void setUp() {
    user = new User();
    user.setId(1);
    user.setName("joão neto");
    user.setEmail("joão@example.com");
    user.setPassword("123teste");

    Microservice microservice = new Microservice(1, "Microservice A");
    List<Role> roles = new ArrayList<>();
    roles.add(new Role(1, user, microservice, Role.userRole.ADMIN));

    user.setUserRoles(roles);
}

@Test
public void testUserToUserDTOWithValidUser() {
    UserDTO userDTOReturn = UserMapper.INSTANCE.userToUserDTO(user);

    assertEquals(user.getUserRoles().get(0).getMicroservice().getNameMicroservice(), userDTOReturn.getMicrosservices().get(0).getName(), "Expected microservice name does not match returned name");
    assertEquals(user.getUserRoles().get(0).getRoleUser(), userDTOReturn.getMicrosservices().get(0).getRoleUser(), "Expected role does not match returned role");
    assertEquals(user.getName(), userDTOReturn.getName(), "Expected name does not match returned name");
    assertEquals(user.getEmail(), userDTOReturn.getEmail(), "Expected email does not match returned email");
}

@Test
public void testUserToUserDTOReturnWithValidUser() {
    UserDTOReturn userDTOReturn = UserMapper.INSTANCE.userToUserDTOReturn(user);

    assertEquals(user.getId(), userDTOReturn.getId(), "Expected ID does not match returned ID");
    assertEquals(user.getName(), userDTOReturn.getName(), "Expected name does not match returned name");
    assertEquals(user.getEmail(), userDTOReturn.getEmail(), "Expected email does not match returned email");
    }
}

