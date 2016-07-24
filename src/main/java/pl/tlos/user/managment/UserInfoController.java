package pl.tlos.user.managment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.tlos.logger.Loggable;

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
	@Async
	public String saveAsync(@RequestParam String name) {
		userSLO.saveUser(name);
		return "OK";
	}

}
