package br.com.ms.e;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EApplication {
	public static void main(String[] args) {
		SpringApplication.run(EApplication.class, args);
	}

}
