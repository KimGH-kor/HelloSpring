package com.sprMbrMbts.mvc07;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class IDaoMemTest {

	@Autowired
	private IDaoMem daoMem;
	
//	@Test
//	public void insertUserTest() {
//		Mem mem = new Mem();
//		
//		mem.setId("juid3");
//		mem.setName("junm3");
//		mem.setPw("jupw3");
//		mem.setTel("jutel3");
//		
//		daoMem.insertUser(mem);
//		
//		Mem mem2 = daoMem.getUser("juid3");
//		assertEquals("jnum3", mem2.getName());
//	}
	
	@Test
	public void getUserTest() {
		Mem mem2 = daoMem.getUser("gold");
		assertEquals("gold_name", mem2.getName());
	}
}
