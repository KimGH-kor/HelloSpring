package com.sprMbrMbts.mvc07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IDaoMem daoMem;
	@Autowired
	private IDaoHist daoHist;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public Mem loginOK(Mem mem) {
		logger.info("loginOK called ==========");
		String inId = mem.getId();
		String inPw = mem.getPw();
		logger.info("입력한 ID : {}", inId);
		logger.info("입력한 PW : {}", inPw);
		
		Mem user = daoMem.getUser(inId);
		if(user == null) {
			return null;
		}
		
		String getPw =user.getPw();
		
		if(inPw.equals(getPw)) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	@Transactional
	public void insertUser(Mem mem) throws Exception {
		String id = mem.getId();
		String pw = mem.getPw();
		String name = mem.getName();
		String tel = mem.getTel();
		
		logger.info("insertUser called ==========");
		logger.info("입력한 ID : {}", id);
		logger.info("입력한 PW : {}", pw);
		logger.info("입력한 NM : {}", name);
		logger.info("입력한 TL : {}", tel);
		
		daoMem.insertUser(mem);
//		System.out.println(3/0);
		daoHist.insertHist("Insert " + mem.toString());
		
	}

}
