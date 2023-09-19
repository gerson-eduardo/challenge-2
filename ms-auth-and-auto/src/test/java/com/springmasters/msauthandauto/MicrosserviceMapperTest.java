package com.springmasters.msauthandauto;

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
        // Crie instâncias de Microservice e User para testar
        microservice = new Microservice();
        microservice.setNameMicroservice("Microservice Name");

        user = new User();
        user.setEmail("user@example.com");

        role = new Role();
        role.setRoleUser(userRole.ADMIN);
    }

    @Test
    public void testMsToBindMs() {
        // Chame o método a ser testado
        BindMsDTOReturn result = MicroserviceMapper.INSTANCE.msToBindMs(microservice, user);

        // Realize as asserções
        assertEquals("user@example.com", result.getEmail());
        assertEquals("Microservice Name", result.getMicroservice());
    }

    @Test
    public void testMsTomsDTO() {
        // Chame o método a ser testado
        MicrosserviceDTO result = MicroserviceMapper.INSTANCE.msTomsDTO(microservice, role);

        // Realize as asserções
        assertEquals("Microservice Name", result.getName());
        assertEquals(userRole.ADMIN, result.getRoleUser());
    }
}

