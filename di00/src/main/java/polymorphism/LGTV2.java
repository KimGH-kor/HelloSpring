package polymorphism;

public class LGTV2 implements TV {

	@Override
	public void powerOn() {
		System.out.println("LGTV---전원을 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV---전원을 끈다.");

	}

	@Override
	public void volumeUp() {
		System.out.println("LGTV---사운드 UP");

	}

	@Override
	public void volumeDown() {
		System.out.println("LGTV---사운드 DOWN");
	}

}
