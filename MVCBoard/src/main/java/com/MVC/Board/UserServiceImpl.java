package com.MVC.Board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IDaoCst daoCst;
	@Autowired
	private IDaoHist daoHist;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public List<Cst> getUsers(String start){
		logger.info("selectAll called ==========");
		int rowNum = 5;
		int result = (Integer.parseInt(start)-1)*rowNum+1; 
		return daoCst.getUsers(String.valueOf(result));
	}
	
	@Override
	@Transactional
	public void insertUser(Cst cst) throws Exception {
		String code = cst.getCode();
		String name = cst.getName();
		String email = cst.getEmail();
		String tel = cst.getTel();
		String weight = cst.getWeight();
		
		logger.info("insertUser called ==========");
		logger.info("입력한 ID : {}", code);
		logger.info("입력한 PW : {}", name);
		logger.info("입력한 EM : {}", email);
		logger.info("입력한 TL : {}", tel);
		logger.info("입력한 WG : {}", weight);

		daoCst.insertUser(cst);
//		System.out.println(3/0);
		daoHist.insertHist("Insert " + cst.toString());
		
	}

	@Override
	@Transactional
	public void updateUser(Cst cst) throws Exception {
		String code = cst.getCode();
		String name = cst.getName();
		String email = cst.getEmail();
		String tel = cst.getTel();
		String weight = cst.getWeight();
		
		logger.info("updateUser called ==========");
		logger.info("입력한 ID : {}", code);
		logger.info("입력한 PW : {}", name);
		logger.info("입력한 EM : {}", email);
		logger.info("입력한 TL : {}", tel);
		logger.info("입력한 WG : {}", weight);

		daoCst.updateUser(cst);
//		System.out.println(3/0);
		daoHist.insertHist("Update " + cst.toString());
	}

	@Override
	@Transactional
	public void deleteUser(String code) throws Exception {
		logger.info("delete called ==========");
		
		daoCst.deleteUser(code);
		Cst cst = daoCst.getUser(code);
		daoHist.insertHist("Delete " + cst.toString());
		
	}

	@Override
	public Cst getUser(String code) {
		logger.info("select called ==========");
		Cst cst = daoCst.getUser(code);
		return cst;
	}

	@Override
	public String getRow() {
		 String row = daoCst.getRow();
		 int num = Integer.parseInt(row)%5;
		 if(num == 0) {
			 return String.valueOf(Integer.parseInt(row)/5);
		 }else {
			 return String.valueOf(Integer.parseInt(row)/5+1);
		 }
	}

}
