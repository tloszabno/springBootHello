package pl.tlos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloBootApplication.class, args);
	}
}
