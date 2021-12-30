package basAnno;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("histDao")
public class HistDAO {
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insertHist(String contents) throws Exception{
		mybatis.insert("HistDAO.insertHist", contents);
	}
	
}
