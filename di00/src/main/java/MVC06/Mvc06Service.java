package MVC06;

import java.util.ArrayList;
import java.util.HashMap;

public class Mvc06Service implements IMvc06Service{
	IMvc06Dao dao = null;
	
	public void setDao(IMvc06Dao dao) {
		this.dao = dao;
	}

	public Mvc06Service() {
	}
	
	public HashMap<String, Object> multi(int code) {
		HashMap<String, Object> hm = new HashMap<String, Object>();

		ArrayList<Customer> cstList = dao.sltMulti(code);

		if (cstList.size() == 0) {
			hm.put("MSG", "해당 자료가 없습니다.");
		} else {
			hm.put("MSG", "정상 처리 되었습니다.");
		}
		hm.put("LIST", cstList);

		return hm;
	}

	public HashMap<String, Object> insert(Customer cst) {
		HashMap<String, Object> hm = new HashMap<String, Object>();

		Customer cstDTO = dao.sltOne(cst.getCode());

		if (cstDTO == null) {
			int c = dao.insertCst(cst);

			if (c > 0) {
				hm.put("MSG", "정상 처리 되었습니다.");
			} else {
				hm.put("MSG", "오류가 발생하였습니다.");
			}

		} else {
			hm.put("MSG", "해당 자료가 이미 있습니다");

		}
		return hm;
	}

	public HashMap<String, Object> update(Customer cst) {
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

	public HashMap<String, Object> delete(int code) {
		HashMap<String, Object> hm = new HashMap<String, Object>();

		Customer cstDTO = dao.sltOne(code);

		if (cstDTO == null) {
			hm.put("MSG", "해당 자료가 없습니다");
		} else {
			int c = dao.deleteCst(code);

			if (c > 0) {
				hm.put("MSG", "정상 처리 되었습니다.");
			} else {
				hm.put("MSG", "오류가 발생하였습니다.");
			}
		}
		return hm;
	}

	public HashMap<String, Object> end() {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		dao.conClose();
		String msg = "종료합니다.";
		hm.put("MSG", msg);
		return hm;
	}
}
