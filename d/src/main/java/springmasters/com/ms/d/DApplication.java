package springmasters.com.ms.d;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DApplication {
	public static void main(String[] args) {
		SpringApplication.run(DApplication.class, args);
	}
}
