package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	@BeforeClass
	public static void setUpBeforeClass()throws Exception{
		System.out.println("setUpBeforeClass");
	}
	
	@AfterClass
	public static void tearDownAfterClass()throws Exception{
		System.out.println("tearDownAfterClass");
	}
	
	@Before
	public void setUp() throws Exception{
		System.out.println("setUp");
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("tearDown");
	}
	
	@Test
	public void testSum() {
		Calculator calculator = new Calculator();
		System.out.println("testSum 1");
		assertEquals(30, calculator.sum(10, 20));
		System.out.println("testSum 2");
	}
	
	@Test
	public void testSumFail() {
		Calculator calculator = new Calculator();
		System.out.println("testSumFail 1");
		assertEquals(31, calculator.sum(10, 20));
		System.out.println("testSumFail 2");
	}

}
