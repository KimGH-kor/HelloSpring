package custAnno;

import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("histDao")
public class Mvc06HistDao {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insHist(CstHist csthist) throws Exception {
		mybatis.insert("HistDAO.insertHist",csthist);
	}
}
