package springmasters.com.ms.d.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmasters.com.ms.d.Consumer.AuthAndAutoConsumer;
import springmasters.com.ms.d.Consumer.Role;

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
}
