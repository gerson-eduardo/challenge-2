package springmasters.com.ms.d.Consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-schola-d", url = "http://localhost:8080/ms-auth-and-auto/")
public interface AuthAndAutoConsumer {
    @GetMapping("/api/users/{id}")
    UserConsumer user;
}
