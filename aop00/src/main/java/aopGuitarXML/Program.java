package aopGuitarXML;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {
	public static void main(String[] args) throws PerformanceExceoption {
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("aopGuitarXML.xml");
		Performer performer = factory.getBean("ABBA", Performer.class);
		performer.perform("Good");
		System.out.println("=============================");
		performer.perform("Error");
		
		factory.close();
	}

}
