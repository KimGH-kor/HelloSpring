package com.MVC.TestSpring;

import java.util.List;

public interface IDaoMbr {
	//pk체크용
	Mbr getMbr(String code);
	
	//모든 사람에 대한 정보
	List<Mbr> getMbrs();

	// insert 문
	void insertMbr(Mbr Mbr);

}
