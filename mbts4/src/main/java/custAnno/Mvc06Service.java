package custAnno;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service("custSrv")
public class Mvc06Service {
	@Autowired
	Mvc06CustDao custDao;
	@Autowired
	Mvc06HistDao histDao;
	
	HashMap<String, Object> hm;
	@Transactional(readOnly = true)
	public HashMap<String, Object> getcstMulti(String code) throws Exception {
		hm = new HashMap<>();
		
		hm.put("LIST", custDao.sltMulti(code));
		hm.put("MSG", "정상 처리 되었습니다.");
		return hm;
	}

	public HashMap<String, Object> cstInsert(Customer cst) throws Exception {
		hm = new HashMap<>();
		String msg;

		Customer cstDTO = custDao.sltOne(cst.getCode());

		if (cstDTO != null) {
			msg = "해당 자료가 이미 있습니다.";
			hm.put("MSG", msg);
			return hm;
		}

		custDao.insertCst(cst);
		CstHist hist = new CstHist();
		
		hist.setReg_date(new Date().toString());
		hist.setData("Insert "+ cst.toString());
		histDao.insHist(hist);
		msg = "정상 등록 되었습니다.";
		hm.put("MSG", msg);
		return hm;

	}

	public HashMap<String, Object> cstUpdate(Customer cst) throws Exception {
		hm = new HashMap<>();
		CstHist hist = new CstHist();
		String msg;

		Customer cstDTO = custDao.sltOne(cst.getCode());

		if (cstDTO == null) {
			msg = "해당 자료가 없습니다.";
			hm.put("MSG", msg);
			return hm;
		}
		hist.setReg_date(new Date().toString());
		hist.setData("Update "+ cstDTO.toString());
		histDao.insHist(hist);
		
		cstDTO.setTel(cst.getTel());
		custDao.updateCst(cstDTO);

		msg = "정상 수정 되었습니다.";

		hm.put("MSG", msg);
		return hm;
	}
	

	public HashMap<String, Object> cstDelete(String code) throws Exception {
		hm = new HashMap<>();
		CstHist hist = new CstHist();
		String msg = null;
		Customer cstDTO = custDao.sltOne(code);

		if (cstDTO == null) {
			msg = "해당 자료가 없습니다.";
			hm.put("MSG", msg);
			return hm;
		}

		custDao.deleteCst(code);

		hist.setReg_date(new Date().toString());
		hist.setData("Delete "+ cstDTO.toString());
		histDao.insHist(hist);

		msg = "정상 삭제 되었습니다.";

		hm.put("MSG", msg);
		return hm;
	}
}