package diexam;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarUserP {
	public static void main(String[] args) {
		AbstractApplicationContext factory 
			= new GenericXmlApplicationContext("diexamP.xml");
//		Car car = (Car)factory.getBean("green");
//		Car car = (Car)factory.getBean("black");
		Car car = (Car)factory.getBean("green");
		
		car.speedUp();
		car.speedDown();
		car.soundUp();
		car.soundDown();
		car.strongOpen();
		
		factory.close();
	}
}
