package springmasters.com.ms.d.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmasters.com.ms.d.Consumer.AuthAndAutoConsumer;
import springmasters.com.ms.d.Consumer.Role;
import springmasters.com.ms.d.Consumer.User;
import springmasters.com.ms.d.DTO.UserDTO;
import springmasters.com.ms.d.DTO.Mapper.UserMapper;

@Service
public class MsScholaService {
    private final AuthAndAutoConsumer consumer;

    @Autowired
    public MsScholaService(AuthAndAutoConsumer consumer){
        this.consumer = consumer;
    }

    public Role getRole(Integer idUser,Integer idMicrosservice){
        Role role = consumer.getRole(idUser, idMicrosservice);
        return role;
    }

    public UserDTO getUserById(Integer idUser, Integer idMicrosservice){
        User user = consumer.getUser(idUser);
        Role role = getRole(idUser, idMicrosservice);

        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user, role);
        return userDTO;
    }
}
