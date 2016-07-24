package pl.tlos.user.managment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.tlos.logger.Loggable;

@Controller
public class UserInfoController {

	@RequestMapping("/user/info")
	@ResponseBody
	@Loggable
	public String getInfo(@RequestParam String name) {
		return "hello " + name;
	}

	@RequestMapping("/user/infoEx")
	@ResponseBody
	@Loggable
	public String getInfoAnon() throws Exception {
		throw new Exception("Nic");
	}

}
