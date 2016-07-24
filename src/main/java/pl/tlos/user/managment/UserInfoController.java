package pl.tlos.user.managment;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.tlos.logger.Loggable;
import pl.tlos.logger.Loggers;

@Controller
public class UserInfoController {

	@Autowired
	UserSLO userSLO;

	@RequestMapping("/user/info")
	@ResponseBody
	@Loggable
	public String getInfo(@RequestParam String name) {
		return "hello " + name;
	}

	@RequestMapping("/user/saveAsync")
	@ResponseBody
	@Loggable
	public Callable<String> saveAsync(@RequestParam String name) {
		userSLO.saveUser(name);
		return () -> {
			Loggers.forThis().warn("saveAsync -> " + Thread.currentThread().getName());
			return "OK";
		};
	}

}
