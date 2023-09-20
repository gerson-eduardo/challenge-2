package com.springmasters.msauthandauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmasters.msauthandauto.DTO.MicrosserviceDTOReturn;
import com.springmasters.msauthandauto.service.MicrosserviceService;

@RestController
@RequestMapping(value = "api/microsservice/")
public class MicrosserviceController {
    private final MicrosserviceService microsserviceService;

    @Autowired
    public MicrosserviceController(MicrosserviceService microsserviceService){
        this.microsserviceService = microsserviceService;
    }

    @GetMapping("/{id_microsservice}")
    public ResponseEntity<MicrosserviceDTOReturn>getMicrosserviceById(@PathVariable Integer id_microsservice){
        return microsserviceService.getById(id_microsservice);
    }
}
