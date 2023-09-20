package br.com.ms.a.controller;

import br.com.ms.a.feingnclient.CentralFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/scholar/")
public class MsAController {
    private final CentralFeign central;

    @Autowired
    public MsAController(CentralFeign central) {
        this.central = central;
    }

    @GetMapping(value = "microsservice/{id_microsservice}")
    public ResponseEntity<Object> getAllByMicrosservice(@PathVariable Integer id_microsservice) {
        return central.getByIdMicrosservice(id_microsservice);
    }
    @GetMapping(value = "{id_user}/microsservice/{id_microsservice}")
    public ResponseEntity<Object> getAllUser(@PathVariable Integer id_user, @PathVariable Integer id_microsservice) {
        return central.getAllByIdUserIdMicrosservce(id_user, id_microsservice);
    }
}

