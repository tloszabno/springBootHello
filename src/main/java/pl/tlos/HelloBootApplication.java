package pl.tlos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class HelloBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloBootApplication.class, args);
	}
}
