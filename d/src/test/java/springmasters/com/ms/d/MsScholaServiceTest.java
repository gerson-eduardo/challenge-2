package springmasters.com.ms.d;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import springmasters.com.ms.d.Consumer.AuthAndAutoConsumer;
import springmasters.com.ms.d.Consumer.Microsservice;
import springmasters.com.ms.d.Consumer.Role;
import springmasters.com.ms.d.Consumer.RoleWithUser;
import springmasters.com.ms.d.Consumer.User;
import springmasters.com.ms.d.DTO.MicrosserviceDTO;
import springmasters.com.ms.d.DTO.UserDTO;
import springmasters.com.ms.d.Service.MsScholaService;

public class MsScholaServiceTest {

    @Mock
    private AuthAndAutoConsumer consumer;

    @InjectMocks
    private MsScholaService msScholaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById() {
        User user = new User(1, "Test User", "test@example.com");
        Role role = new Role("USER");

        when(consumer.getUser(1)).thenReturn(user);
        when(consumer.getRole(1, 1)).thenReturn(role);

        ResponseEntity<UserDTO> response = msScholaService.getUserById(1, 1);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        UserDTO userDTO = response.getBody();
        assertNotNull(userDTO);
        assertEquals(user.getName(), userDTO.getName());
        assertEquals(role.getRole(), userDTO.getRole());
    }

    @Test
    public void testGetUsersByMicrosserviceId() {
        List<RoleWithUser> roles = new ArrayList<>();
        roles.add(new RoleWithUser("Test Role", "USER"));
        Microsservice microsservice = new Microsservice("Test Microsservice");

        when(consumer.getRoleWithUser(1)).thenReturn(roles);
        when(consumer.getMicrosservice(1)).thenReturn(microsservice);

        ResponseEntity<MicrosserviceDTO> response = msScholaService.getUsersByMicrosserviceId(1);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        MicrosserviceDTO microsserviceDTO = response.getBody();
        assertNotNull(microsserviceDTO);
        assertEquals(1, microsserviceDTO.getMicrosserviceId());
        assertEquals(microsservice.getName(), microsserviceDTO.getMicrosserviceName());
    }
}

