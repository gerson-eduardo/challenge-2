package springmasters.com.ms.d;

import org.junit.jupiter.api.Test;

import springmasters.com.ms.d.Consumer.Role;
import springmasters.com.ms.d.Consumer.User;
import springmasters.com.ms.d.DTO.UserDTO;
import springmasters.com.ms.d.DTO.Mapper.UserMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {
    @Test
    public void testUserToUserDTO() {
        User user = new User(1,"test", "test@test.com");
        Role role = new Role("ADMIN");
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user, role);
        assertEquals(user.getName(), userDTO.getName());        
        assertEquals(role.getRole(), userDTO.getRole());
    }
}
