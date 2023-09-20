package com.springmasters.msauthandauto;

import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.repository.MicroserviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsAuthAndAutoApplication {
    @Bean
    public CommandLineRunner init(@Autowired MicroserviceRepository microserviceRepository) {
        return args -> {
            Microservice msScholarA = new Microservice("scholar a");
            microserviceRepository.save(msScholarA);
            Microservice msScholarB = new Microservice("scholar b");
            microserviceRepository.save(msScholarB);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(MsAuthAndAutoApplication.class, args);
    }

}