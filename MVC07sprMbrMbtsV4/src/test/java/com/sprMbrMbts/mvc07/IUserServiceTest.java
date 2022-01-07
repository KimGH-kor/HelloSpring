package com.sprMbrMbts.mvc07;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class IUserServiceTest {
	@Autowired
	private IUserService userService;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("setUp");
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("tearDown");
	}
	
	@Test
	public void loginOKTest() throws Exception {
		Mem mem = new Mem();
		
		mem.setId("juid1");
		mem.setPw("jupw1");
		
		Mem user = userService.loginOK(mem);
		
//		assertNotNull(object);
		assertEquals("juid1", user.getId());
	}
	
	@Test
	public void insertUserTest() throws Exception{
		Mem mem = new Mem();
		
		mem.setId("juid5");
		mem.setName("junm5");
		mem.setPw("jupw5");
		mem.setTel("jutel5");

		userService.insertUser(mem);
		Mem user = userService.loginOK(mem);
		assertEquals("juid5", user.getName());
	}
	
}
