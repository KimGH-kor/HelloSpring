package com.MVC.Board;

import java.util.List;

public interface IUserService {
	List<Cst> getUsers(String start);
	Cst getUser(String code);
	String getRow();
	void insertUser(Cst cst) throws Exception;
	void updateUser(Cst cst) throws Exception;
	void deleteUser(String code) throws Exception;
}
