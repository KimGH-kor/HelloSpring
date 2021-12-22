package diexam;

public class BlackCar implements Car {
	Speaker speaker;
	int price;
	StrongWindow window;
	
	public BlackCar() {
		// TODO Auto-generated constructor stub
	}
	
	public BlackCar(Speaker speaker, int price, StrongWindow window) {
		this.speaker = speaker;
		this.price = price;
		this.window = window;
	}

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
		System.out.println("BlackCar의 가격은 "+price);
		System.out.println("BlackCar의 스피드UP");
	}

	@Override
	public void speedDown() {
		System.out.println("BlackCar의 스피드DOWN");
	}

	@Override
	public void soundUp() {
//		System.out.println("BlackCar의 사운드UP");
		speaker.soundUp();
	}

	@Override
	public void soundDown() {
//		System.out.println("BlackCar의 사운드DOWN");
		speaker.soundDown();
	}

}
