package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import practice.DTO.Customer;

public class Mvc06View {

	public static void main(String[] args) {
		Mvc06Service sv = new Mvc06Service();

		Scanner sc = new Scanner(System.in);

		while (true) {
			HashMap<String, Object> hm = input(sc);
			String key = (String) hm.get("KEY");

			// 종료
			if ("9".equals(key)) {
				hm = sv.cstEnd();
				output(hm);
				break;
			}

			// 조건조회
			if ("1".equals(key)) {

				hm = sv.cstMulti((Integer) hm.get("CODE"));
			}

			// 입력
			if ("2".equals(key)) {

				hm = sv.cstInsert((Customer) hm.get("CST"));
			}

			// 정보변경
			if ("3".equals(key)) {

				hm = sv.cstUpdate((Customer) hm.get("CST"));
			}

			// 삭제
			if ("4".equals(key)) {

				hm = sv.cstDelete((Integer) hm.get("CODE"));
			}
			output(hm);
		}

	}
	
	public static HashMap<String, Object> input(Scanner sc) {
		HashMap<String, Object> hm = new HashMap<String, Object>();

		int code;
		String name, email, tel;
		Double weight;

		Customer cst = null;

		System.out.print("1:조건조회, 2:입력, 3:정보변경, 4:삭제, 9:종료 = ");
		String key = sc.next();

		if ("1".equals(key)) {
			System.out.println("조회할 회원코드를 입력하세요");
			System.out.print("코드     >>");
			code = sc.nextInt();

			hm.put("CODE", code);
		}

		if ("2".equals(key)) {
			System.out.println("고객 정보를 입력하세요");
			System.out.print("코드     >>");
			code = sc.nextInt();
			System.out.print("성명     >>");
			name = sc.next();
			System.out.print("이메일   >>");
			email = sc.next();
			System.out.print("전화번호 >>");
			tel = sc.next();
			System.out.print("체중     >>");
			weight = sc.nextDouble();

			cst = new Customer();

			cst.setCode(code);
			cst.setName(name);
			cst.setEmail(email);
			cst.setTel(tel);
			cst.setWeight(weight);

			hm.put("CST", cst);
		}

		if ("3".equals(key)) {
			System.out.println("변경할 고객번호를 입력하세요");
			System.out.print("코드     >>");
			code = sc.nextInt();
			System.out.print("전화번호 >>");
			tel = sc.next();

			cst = new Customer();

			cst.setCode(code);
			cst.setTel(tel);

			hm.put("CST", cst);
		}

		if ("4".equals(key)) {
			System.out.println("삭제할 회원코드를 입력하세요");
			System.out.print("코드     >>");
			code = sc.nextInt();

			hm.put("CODE", code);
		}

		hm.put("KEY", key);

		return hm;
	}

	public static void output(HashMap<String, Object> hm) {
		ArrayList<Customer> cstList = (ArrayList<Customer>) hm.get("LIST");
		if (cstList != null) {
			for (int i = 0; i < cstList.size(); i++) {
				System.out.print(cstList.get(i).getCode() + "\t");
				System.out.print(cstList.get(i).getName() + "\t");
				System.out.print(cstList.get(i).getEmail() + "\t");
				System.out.print(cstList.get(i).getTel() + "\t");
				System.out.println(cstList.get(i).getWeight());
			}
		}
		System.out.println(hm.get("MSG"));
	}

}