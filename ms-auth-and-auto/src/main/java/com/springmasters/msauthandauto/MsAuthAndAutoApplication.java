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
            microserviceRepository.save(new Microservice("scholar a"));
            microserviceRepository.save(new Microservice("scholar b"));
            microserviceRepository.save(new Microservice("scholar c"));
            microserviceRepository.save(new Microservice("scholar d"));
            microserviceRepository.save(new Microservice("scholar e"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(MsAuthAndAutoApplication.class, args);
    }

}
