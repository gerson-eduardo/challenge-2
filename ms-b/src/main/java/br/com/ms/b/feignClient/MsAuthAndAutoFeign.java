package br.com.ms.b.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-auth-and-auto", url = "http://localhost:8080/ms-auth-and-auto/")
public interface MsAuthAndAutoFeign {
    @GetMapping(value = "api/roles/{id_user}/microsservice/{id_microsservice}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getAllByIdUserIdMicrosservce(@PathVariable Integer id_user,
                                                        @PathVariable Integer id_microsservice);

    @GetMapping(value = "api/roles/{id_microsservice}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getByIdMicrosservice(@PathVariable Integer id_microsservice);

}
