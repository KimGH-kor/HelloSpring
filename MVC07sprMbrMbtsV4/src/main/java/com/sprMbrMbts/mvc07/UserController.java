package com.sprMbrMbts.mvc07;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/")
	public String home() {
		logger.info("home called =========");
		return "redirect:/main.jsp";
	}
	
	@RequestMapping("login")
	public String login() {
		logger.info("login called ==========");
		return "login";
	}
	
	@RequestMapping("loginOK")
	public String loginOK(Mem mem, HttpSession session) {
		Mem user = userService.loginOK(mem);
		
		if(user == null) {
			return "login";
		}else {
			session.setAttribute("user", user);
			return "loginConfirm";
		}
	}
	
	@RequestMapping("getUser")
	public String getUser() {
		logger.info("getUser called ==========");
		return "getUser";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		logger.info("logout called ==========");
		session.invalidate();
		return "logoutOK";
	}
	
	@RequestMapping("insertMem")
	public String insert() {
		logger.info("insertMem called ==========");
		return "insertMem";
	}
	
	@RequestMapping("insertUser")
	public String insertUser(Mem mem) throws Exception{
		userService.insertUser(mem);
		return "login";
	}
	
}
