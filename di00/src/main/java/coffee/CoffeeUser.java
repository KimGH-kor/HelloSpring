package coffee;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CoffeeUser {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AbstractApplicationContext factory
			= new GenericXmlApplicationContext("coffee.xml");
		Coffee coffee1 = (Coffee)factory.getBean("coffee");
		Coffee coffee2 = (Coffee)factory.getBean("coffee");
		Coffee coffee3 = (Coffee)factory.getBean("coffee");
		
		factory.close();
	}
}
