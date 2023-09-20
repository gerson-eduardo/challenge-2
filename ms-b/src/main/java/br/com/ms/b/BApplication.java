package br.com.ms.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BApplication {

	public static void main(String[] args) {
		SpringApplication.run(BApplication.class, args);
	}

}
