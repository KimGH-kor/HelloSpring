package com.MVC.Board;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/")
	public String home() {//클리어
		logger.info("home called =========");
		return "redirect:/index.jsp";
	}

	@RequestMapping("select")//페이지 수 받아야함
	public String selectAll(@RequestParam("P_NUM") String start, Model model) {
		logger.info("select called ==========");
		// 다건 조회 후 보내주기selectAll()써야함
		model.addAttribute("C_LIST", userService.getUsers(start)); 
		model.addAttribute("P_NUM",start);
		model.addAttribute("NEXT_NUM", userService.getRow());
		return "select";
	}

	@RequestMapping("insert")//클리어
	public String insert() {
		logger.info("insert called ==========");
		return "insert";

	}

	@RequestMapping("insertAction")
	public String insertAction(Cst cst, Model model) throws Exception {
		//정보 받은거 넣어야함 그 후 제대로 된지 안된지 확인
		System.out.println(cst.getName());
		userService.insertUser(cst);
		
		model.addAttribute("C_LIST", userService.getUsers("1")); 
		model.addAttribute("P_NUM","1");
		model.addAttribute("NEXT_NUM", userService.getRow());
		return "select";
	}

	@RequestMapping("update")
	public String update(@RequestParam("CODE") String code, Model model) {
		logger.info("getUser called ==========");
		
		//누른 정보 받아와서 수정 페이지 이동
		model.addAttribute("CUST", userService.getUser(code));
		return "update";
	}

	@RequestMapping("updateAction")
	public String updateAction(Cst cst, Model model) throws Exception {
		logger.info("updateUser called ==========");
		//수정 정보 넣기
		userService.updateUser(cst);
		model.addAttribute("C_LIST", userService.getUsers("1")); 
		model.addAttribute("P_NUM","1");
		model.addAttribute("NEXT_NUM", userService.getRow());
		return "select";
	}
	
	@RequestMapping("delete")
	public String deleteUser(@RequestParam("CODE") String code, Model model) throws Exception {
		logger.info("delete called ==========");
		userService.deleteUser(code);
		model.addAttribute("C_LIST", userService.getUsers("1")); 
		model.addAttribute("P_NUM","1");
		model.addAttribute("NEXT_NUM", userService.getRow());
		return "select";
	}
}
