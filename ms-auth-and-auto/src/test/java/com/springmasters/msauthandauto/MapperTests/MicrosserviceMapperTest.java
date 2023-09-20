package com.springmasters.msauthandauto.MapperTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.springmasters.msauthandauto.DTO.BindMsDTOReturn;
import com.springmasters.msauthandauto.DTO.MicrosserviceDTO;
import com.springmasters.msauthandauto.DTO.Mapper.MicroserviceMapper;
import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.model.Role;
import com.springmasters.msauthandauto.model.User;
import com.springmasters.msauthandauto.model.Role.userRole;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MicrosserviceMapperTest {
    private Microservice microservice;
    private User user;
    private Role role;
    
    @BeforeEach
    public void setUp() {
        microservice = new Microservice();
        microservice.setNameMicroservice("Microservice Name");

        user = new User();
        user.setEmail("user@example.com");

        role = new Role();
        role.setRoleUser(userRole.ADMIN);
    }

    @Test
    public void testMsToBindMs() {
        BindMsDTOReturn result = MicroserviceMapper.INSTANCE.msToBindMs(microservice, user);

        assertEquals("user@example.com", result.getEmail(), "Expected email does not match returned email");
        assertEquals("Microservice Name", result.getMicroservice(), "Expected microservice name does not match returned name");
    }

    @Test
    public void testMsTomsDTO() {
        MicrosserviceDTO result = MicroserviceMapper.INSTANCE.msTomsDTO(microservice, role);

        assertEquals("Microservice Name", result.getName(), "Expected microservice name does not match returned name");
        assertEquals(userRole.ADMIN, result.getRoleUser(), "Expected user role does not match returned role");
    }
}


