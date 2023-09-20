package springmasters.com.ms.d.Consumer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms-schola-d", url = "http://localhost:8080/ms-auth-and-auto/")
public interface AuthAndAutoConsumer {
    @GetMapping("/api/users/{id}")
    User getUser(@PathVariable Integer id);

    @GetMapping("/api/microsservice/{id}")
    Microsservice getMicrosservice(@PathVariable Integer id);

    @GetMapping("/api/roles/{id_user}/microsservice/{id_microsservice}")
    Role getRole(@PathVariable Integer id_user,@PathVariable Integer id_microsservice);

    @GetMapping("/api/roles/{id_microsservice}")
    List<RoleWithUser> getRoleWithUser(@PathVariable Integer id_microsservice);
}
