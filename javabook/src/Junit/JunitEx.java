package Junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JunitEx {

	//예외테스트
	@Test(expected = NumberFormatException.class)
	public void testException() {
		String str = "hello";
		System.out.println(Integer.parseInt(str));
	}
	
	//테스트 시간 제한
	@Test(timeout = 1000)
	public void testTimeout() {
		long sum = 0;
		for(int i = 0; i < 10000; i++) {
			for(int j = 0; j < 10000; j++) {
				sum += j;
			}
		}
		System.out.println(sum);
	}
	
	//테스트 무시
	@Ignore
	@Test
	public void testIgnore() {
		assertTrue(false);
	}
	
	//배열 지원 - 값, 순서 모두 동일해야함
	@Test
	public void testAssertArrayEquals() {
		Object[] a = {"Java", "Pytion", 1};
		Object[] b = {"Java", "Pytion", 1};
		assertArrayEquals(a, b);
	}

}
