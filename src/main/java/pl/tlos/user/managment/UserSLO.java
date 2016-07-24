package pl.tlos.user.managment;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import pl.tlos.logger.Loggable;
import pl.tlos.logger.Loggers;

@Component
public class UserSLO {

	@Loggable
	@Async
	public void saveUser(String name) {
		Loggers.forThis().warn("Name ->" + name);
		Loggers.forThis().warn("Thread ->" + Thread.currentThread().getName());
	}
}
