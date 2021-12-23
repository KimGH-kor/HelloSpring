package diAnno;

import org.springframework.stereotype.Component;

//@Component
@Component("melon")
public class MelonSpeaker implements Speaker {

	@Override
	public void soundUp() {
		System.out.println("멜론 스피커 사운드 UP");
	}

	@Override
	public void soundDown() {
		System.out.println("멜론 스피커 사운드 DOWN");
	}

}
