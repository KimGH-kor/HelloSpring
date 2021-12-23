package diAnno;

import org.springframework.stereotype.Component;

@Component
//@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		
	}

	@Override
	public void soundUp() {
		System.out.println("애플 스피커 사운드 UP");		
	}

	@Override
	public void soundDown() {
		System.out.println("애플 스피커 사운드 Down");		
	}
	
}
