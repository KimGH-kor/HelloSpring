package diAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("green")
public class GreenCar implements Car{
	@Autowired
	@Qualifier("melon")
	Speaker speaker;
	int price;
	@Autowired
	StrongWindow window;

	public void setWindow(StrongWindow window) {
		this.window = window;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	
	@Override
	public void strongOpen() {
		window.strongOpen();
	}

	@Override
	public void speedUp() {
		System.out.println("GreenCar의 가격은 "+price);
		System.out.println("GreenCar의 스피드UP");
	}

	@Override
	public void speedDown() {
		System.out.println("GreenCar의 스피드DOWN");
	}

	@Override
	public void soundUp() {
		System.out.println("GreenCar의 사운드UP");
		speaker.soundUp();
	}

	@Override
	public void soundDown() {
		System.out.println("GreenCar의 사운드DOWN");
		speaker.soundDown();
	}
}
