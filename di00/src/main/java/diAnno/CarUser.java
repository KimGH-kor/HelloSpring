package diAnno;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarUser {
	public static void main(String[] args) {
		AbstractApplicationContext factory 
			= new GenericXmlApplicationContext("diAnno.xml");
//		Car car = (Car)factory.getBean("green");
		Car car = (Car)factory.getBean("black");
		car.speedUp();
		car.speedDown();
		car.soundUp();
		car.soundDown();
		car.strongOpen();
		
		factory.close();
	}
}
