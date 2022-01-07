package com.myspring.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String doA() {
		logger.info("doA called ================");
		return "doA";
	}
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB called ================");
	}
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		//@ModelAttribute("msg")는  String msg = request.getAttribute("msg");와 같다
		
		logger.info("doC called ================", msg);
		return "result";
	}
	@RequestMapping("doD")
	public String doD(Model model) {
		logger.info("doD called ================");
		Mem mem = new Mem();
		mem.setId("will");
		mem.setPw("1234");
		model.addAttribute(mem);
		return "memDetail";
	}
	@RequestMapping("doE")
	public String doE() {
		logger.info("doE called ================");
		return "redirect:/doF";
	}
	@RequestMapping("doF")
	public void doF() {
		logger.info("doF called ================");
	}
	
}
