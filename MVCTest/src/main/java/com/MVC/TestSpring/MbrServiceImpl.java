package com.MVC.TestSpring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;


@Service("mbrService")
public class MbrServiceImpl implements IMbrService {
	@Autowired
	private IDaoMbr dao;

	private static final Logger logger = LoggerFactory.getLogger(MbrServiceImpl.class);
	@Override
	public List<Mbr> getMbrs(Model model) {
		logger.info("selectAll called ==========");
		List<Mbr> list = dao.getMbrs();
		double sum = 0;
		double avg = 0;
		
		for(Mbr mbr : list) {
			sum += Double.parseDouble(mbr.getWeight());
		}
		avg = sum/list.size();
		double result = Math.round(avg * 100) / 100.0;

		model.addAttribute("CNT",list.size());
		model.addAttribute("AVG",result);
		
		
		return list;
	}

	@Override
	@Transactional
	public void insertMbr(Mbr mbr) throws Exception {
		String code = mbr.getCode();
		String name = mbr.getName();
		String weight = mbr.getWeight();
		logger.info("insertUser called ==========");
		logger.info("입력한 ID : {}", code);
		logger.info("입력한 PW : {}", name);
		logger.info("입력한 WG : {}", weight);
		
		Mbr pkC = dao.getMbr(mbr.getCode());
		
		if(pkC != null) {
			logger.warn("이미 존재하는 번호입니다.");
			return;
		}
		dao.insertMbr(mbr);
	}

}
