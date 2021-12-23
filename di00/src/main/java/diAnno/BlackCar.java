package diAnno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("black")
public class BlackCar implements Car{
//@Autowired
//@Qualifier("melon")
//@Qualifier("appleSpeaker")
	@Resource(name="melon")
//@Resoutce(name="appleSpeaker")
	Speaker speaker;
	int price;
	@Autowired
	StrongWindow window;
	
	public BlackCar() {
	}
	
	public BlackCar(Speaker speaker, int price, StrongWindow window) {
		this.speaker = speaker;
		this.price = price;
		this.window = window;
	}
	
	@Override
	public void strongOpen() {
		window.strongOpen();
	}

	@Override
	public void speedUp() {
		System.out.println("BlackCar의 가격은 "+price);
		System.out.println("BlackCar의 스피드UP");
	}

	@Override
	public void speedDown() {
		System.out.println("BlackCar의 스피드DOWN");
	}

	@Override
	public void soundUp() {
		System.out.println("BlackCar의 사운드UP");
		speaker.soundUp();
	}

	@Override
	public void soundDown() {
		System.out.println("BlackCar의 사운드DOWN");
		speaker.soundDown();
	}

}
