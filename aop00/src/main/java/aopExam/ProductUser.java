package aopExam;

import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProductUser {

	public static void main(String[] args) {
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("aopExam.xml");
		
		ProductService psvc = factory.getBean("productService",ProductService.class);
		HashMap<String, Object> hm = psvc.doProc("스템플러");
		System.out.println(hm);
		System.out.println();
				
		psvc = factory.getBean("productService", ProductService.class);
		hm = psvc.doProc("에러");
		System.out.println(hm);
		
		factory.close();
	}

}
