package com.MVC.TestSpring;

import java.util.List;

import org.springframework.ui.Model;

public interface IMbrService {
	List<Mbr> getMbrs(Model model);
	void insertMbr(Mbr mbr) throws Exception;
}
