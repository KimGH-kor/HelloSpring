package com.MVC.Board;

import java.util.List;

public interface IDaoCst {
	
	//모든 사람에 대한 정보
	List<Cst> getUsers(String start);
	
	// 한 사람에 대한 정보 => select 문
	Cst getUser(String code);
	
	String getRow();
	
	// insert 문
	void insertUser(Cst cst);
	
	//update문
	void updateUser(Cst cst);
	
	//delete문
	void deleteUser(String code);
}
