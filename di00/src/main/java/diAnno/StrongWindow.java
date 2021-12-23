package diAnno;

import org.springframework.stereotype.Component;

@Component
//@Component("strong)
public class StrongWindow {
	public void strongOpen() {
		System.out.println("강화유리로 OPEN");
	}
	public void strongClose() {
		System.out.println("강화유리로 CLOSE");
	}
}
