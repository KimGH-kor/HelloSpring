package custAnno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Mvc06View {

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext factory = 
	            new GenericXmlApplicationContext("basAnnoCTX.xml");
		Mvc06Service sv = (Mvc06Service)factory.getBean("custSrv");

		Scanner sc = new Scanner(System.in);

		while (true) {
			HashMap<String, Object> hm = input(sc);
			String btn = (String) hm.get("BTN");

			// 종료
			if ("9".equals(btn)) {
				System.out.println("이용해 주셔서 감사합니다.");
				sc.close();
				break;
			}

			// 조건조회
			if ("1".equals(btn)) {
				hm = sv.getcstMulti((String) hm.get("CODE"));
			}

			// 입력
			if ("2".equals(btn)) {
				hm = sv.cstInsert((Customer) hm.get("CST"));
			}

			// 정보변경
			if ("3".equals(btn)) {
				hm = sv.cstUpdate((Customer) hm.get("CST"));

			}

			// 삭제
			if ("4".equals(btn)) {
				hm = sv.cstDelete((String) hm.get("CODE"));
			}

			output(hm);
		}
		factory.close();
	}

	public static HashMap<String, Object> input(Scanner sc) {
		HashMap<String, Object> hm = new HashMap<String, Object>();

		String code;
		String name, email, tel;
		String weight;

		Customer cst = null;

		System.out.print("1:조건조회, 2:입력, 3:정보변경, 4:삭제, 9:종료 = ");
		String btn = sc.next();

		if ("1".equals(btn)) {
			System.out.println("조회할 회원코드를 입력하세요");

			System.out.print("코드     >>");
			code = sc.next();

			hm.put("CODE", code);
		}

		if ("2".equals(btn)) {
			System.out.println("고객 정보를 입력하세요");

			System.out.print("코드     >>");
			code = sc.next();
			System.out.print("성명     >>");
			name = sc.next();
			System.out.print("이메일   >>");
			email = sc.next();
			System.out.print("전화번호 >>");
			tel = sc.next();
			System.out.print("체중     >>");
			weight = sc.next();

			cst = new Customer();

			cst.setCode(code);
			cst.setName(name);
			cst.setEmail(email);
			cst.setTel(tel);
			cst.setWeight(weight);

			hm.put("CST", cst);
		}

		if ("3".equals(btn)) {
			System.out.println("변경할 고객번호를 입력하세요");

			System.out.print("코드     >>");
			code = sc.next();
			System.out.print("전화번호 >>");
			tel = sc.next();

			cst = new Customer();

			cst.setCode(code);
			cst.setTel(tel);

			hm.put("CST", cst);
		}

		if ("4".equals(btn)) {
			System.out.println("삭제할 회원코드를 입력하세요");

			System.out.print("코드     >>");
			code = sc.next();

			hm.put("CODE", code);
		}

		hm.put("BTN", btn);

		return hm;
	}

	public static void output(HashMap<String, Object> hm) {
		ArrayList<?> cstList = (ArrayList<?>) hm.get("LIST");

		if (cstList != null) {
			for (Object cst : cstList) {
				if (cst instanceof Customer) {

					Customer c = (Customer) cst;

					System.out.print(c.getCode() + "\t");
					System.out.print(c.getName() + "\t");
					System.out.print(c.getEmail() + "\t");
					System.out.print(c.getTel() + "\t");
					System.out.println(c.getWeight());
				}
			}
		}

		System.out.println(hm.get("MSG"));
	}
}