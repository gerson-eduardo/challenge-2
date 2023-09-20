package springmasters.com.ms.d.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmasters.com.ms.d.Consumer.AuthAndAutoConsumer;

@Service
public class MsScholaService {
    private final AuthAndAutoConsumer consumer;

    @Autowired
    public MsScholaService(AuthAndAutoConsumer consumer){
        this.consumer = consumer;
    }
}
