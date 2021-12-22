package diexam;

public class GreenCar implements Car {
	Speaker speaker;
	int price;
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
//		System.out.println("GreenCar의 사운드UP");
		speaker.soundUp();
	}

	@Override
	public void soundDown() {
//		System.out.println("GreenCar의 사운드DOWN");
		speaker.soundDown();
	}

}
