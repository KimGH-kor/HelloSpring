package com.MVC.TestSpring;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MbrController {
	@Autowired
	private IMbrService mbrService;

	private static final Logger logger = LoggerFactory.getLogger(IMbrService.class);
	
	@RequestMapping("select")//페이지 수 받아야함
	public String selectAll(Model model) {
		logger.info("selectAll called =========");
		List<Mbr>list = mbrService.getMbrs(model);
		if(list.size() == 0) {
			return "insert";
		}
		model.addAttribute("LIST", list);
		return "select";
	}

	@RequestMapping("insert")//클리어
	public String insert() throws Exception {
		logger.info("insert called =========");
		return "insert";
	}

	@RequestMapping("insertAction")
	public String insertAction(Mbr mbr) throws Exception {
		logger.info("insertAction called =========");
		mbrService.insertMbr(mbr);
		return "redirect:/select";
	}

	
}
