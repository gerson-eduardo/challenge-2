package com.springmasters.msauthandauto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springmasters.msauthandauto.DTO.MicrosserviceDTOReturn;
import com.springmasters.msauthandauto.DTO.Mapper.MicroserviceMapper;
import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.repository.MicroserviceRepository;

@Service
public class MicrosserviceService {
    private final MicroserviceRepository microsserviceRepository;

    @Autowired
    public MicrosserviceService(MicroserviceRepository microsservice){
        this.microsserviceRepository = microsservice;
    }

    public ResponseEntity<MicrosserviceDTOReturn> getById(Integer id){
        Optional<Microservice> microsservice = microsserviceRepository.findById(id);
        if(microsservice.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Microservice not found with ID: " + id);
        return ResponseEntity.ok(MicroserviceMapper.INSTANCE.msToMsDTOReturn(microsservice.get()));
    }
}
