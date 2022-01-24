package jUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

public class DAOTest {
	DAO dao = new DAO();

	@Test
	public void test1SltMulti() throws Exception {
		List<DTO> list = dao.sltAll();
		
		DTO dto = dao.sltOne("01", "01");
		assertEquals(list.get(0).toString(), dto.toString());
	}

	@Test
	public void test2Insert() throws Exception {
		DTO dto = new DTO();
		dto.setClss("01");
		dto.setSeq("07");
		dto.setKor(80);
		dto.setEng(90);
		dto.setMat(100);
		dao.insert(dto);
		
		dto = dao.sltOne("01", "07");
		assertEquals("01", dto.getClss());
		assertEquals("07", dto.getSeq());
	}

	@Test
	public void test3Update() throws Exception {
		DTO dto = new DTO();
		dto.setClss("01");
		dto.setSeq("06");
		dto.setKor(60);
		dto.setEng(70);
		dto.setMat(70);
		dao.update(dto);
		
		dto = dao.sltOne("01", "06");
		assertEquals(60, dto.getKor());
	}

	@Test
	public void test4SltOne() throws Exception {
		DTO dto = dao.sltOne("01", "01");
		assertEquals("01", dto.getClss());
		assertEquals("01", dto.getSeq());
	}

	@Test
	public void test5Delete() throws Exception {
		dao.delete("01", "05");
		DTO dto = dao.sltOne("01", "05");
		assertNull(dto);

	}

}
