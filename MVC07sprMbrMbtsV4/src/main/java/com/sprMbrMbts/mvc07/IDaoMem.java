package com.sprMbrMbts.mvc07;

public interface IDaoMem {

	// 한 사람에 대한 정보 => select 문
	Mem getUser(String id);
	
	// insert 문
	void insertUser(Mem mem);
}
