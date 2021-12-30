package custAnno;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("custDao")
public class Mvc06CustDao {

	@Autowired
	SqlSessionTemplate myBatis;

	public List<Customer> sltMulti(String code) throws Exception {
		return myBatis.selectList("custDAO.selectMulti",code);
	}

	public Customer sltOne(String code) throws Exception {
		return myBatis.selectOne("custDAO.select",code);	
	}

	public void insertCst(Customer cst) throws Exception {
		myBatis.insert("custDAO.insert", cst);
	}

	public void updateCst(Customer cst) throws Exception {
		myBatis.update("custDAO.update", cst);
	}

	public void deleteCst(String code) throws Exception {
		myBatis.delete("custDAO.delete", code);
	}

}