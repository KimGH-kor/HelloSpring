package basAnno;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("mbrDao")
public class MemberDAO {
	private SqlSession myBatis;
	
	public MemberDAO() {
		myBatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insert(MemberDTO dto) {
		myBatis.insert("mbrDAO.insert", dto);
	}
	
	public void delete(String id) {
		myBatis.update("mbrDAO.delete",id);
	}
	
	public void update(MemberDTO dto) {
		myBatis.update("mbrDAO.update", dto);
	}
	
	public MemberDTO select(String id) {
		return myBatis.selectOne("mbrDAO.select",id);
	}
	
	public List<MemberDTO> selectAll(){
		return myBatis.selectList("mbrDAO.selectAll");
	}
	
	public void commit() {
		myBatis.commit();
	}
	
	public void rollback() {
		myBatis.rollback();
	}
}
