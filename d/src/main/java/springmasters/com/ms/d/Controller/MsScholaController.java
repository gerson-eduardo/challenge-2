package springmasters.com.ms.d.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springmasters.com.ms.d.DTO.MicrosserviceDTO;
import springmasters.com.ms.d.DTO.UserDTO;
import springmasters.com.ms.d.Service.MsScholaService;

@RestController
@RequestMapping(value = "api/schola/")
public class MsScholaController {
    private final MsScholaService service;

    @Autowired
    public MsScholaController(MsScholaService service){
        this.service = service;
    }

    @GetMapping("/{id_user}/microsservice/{id_microsservice}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id_user, @PathVariable Integer id_microsservice){
        return service.getUserById(id_user, id_microsservice);
    }

    @GetMapping("microsservice/{id_microsservice}")
    public ResponseEntity<MicrosserviceDTO> getUserByMicrosservice(@PathVariable Integer id_microsservice){
        return service.getUsersByMicrosserviceId(id_microsservice);
    }
}
