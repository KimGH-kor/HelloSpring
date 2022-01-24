package practice;

import java.util.ArrayList;
import java.util.HashMap;

import practice.DAO.Mvc06Dao;
import practice.DTO.Customer;

public class Mvc06Service {
	Mvc06Dao dao = new Mvc06Dao();

	public HashMap<String, Object> cstMulti(int code) {
		HashMap<String, Object> hm = new HashMap<String, Object>();

		ArrayList<Customer> cstList = dao.sltMulti(code);

		if (cstList.size() == 0) {
			hm.put("MSG", "해당 자료가 없습니다.");
		} else {
			hm.put("MSG", "정상 처리 되었습니다");
		}
		hm.put("LIST", cstList);

		return hm;
	}

	public HashMap<String, Object> cstInsert(Customer cst) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		Customer cstDTO = dao.sltOne(cst.getCode());

		if (cstDTO == null) {
			int c = dao.insertCst(cst);

			if (c > 0) {
				hm.put("MSG", "정상처리");
			} else {
				hm.put("MSG", "오류발생");
			}

		} else {
			hm.put("MSG", "해당자료가 있습니다");

		}
		return hm;
	}

	public HashMap<String, Object> cstUpdate(Customer cst) {
		HashMap<String, Object> hm = new HashMap<String, Object>();

		Customer cstDTO = dao.sltOne(cst.getCode());

		if (cstDTO == null) {
			hm.put("MSG", "해당 자료가 없습니다");
		} else {

			cstDTO.setTel(cst.getTel());
			int c = dao.updateCst(cstDTO);

			if (c > 0) {
				hm.put("MSG", "정상 처리 되었습니다.");
			} else {
				hm.put("MSG", "오류가 발생하였습니다.");
			}

		}

		return hm;
	}

	public HashMap<String, Object> cstDelete(int code) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		Customer cstDTO = dao.sltOne(code);

		if (cstDTO == null) {
			hm.put("MSG", "해당 자료가 없습니다");
		} else {
			int c = dao.deleteCst(code);

			if (c > 0) {
				hm.put("MSG", "정상 처리 되었습니다");
			} else {
				hm.put("MSG", "데이터베이스에서 오류가 발생했습니다.");
			}
		}
		return hm;
	}

	public HashMap<String, Object> cstEnd() {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		dao.conClosed();
		String msg = "END";
		hm.put("MSG", msg);
		return hm;
	}
}