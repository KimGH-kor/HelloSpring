package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import practice.DTO.Customer;

public class View2 {

	public static void main(String[] args) {
		HashMap<String, Object> hm = null;
		Scanner sc = null;

		hm = input(sc);
		output(hm);
	}

	public static HashMap<String, Object> input(Scanner sc) {
		HashMap<String, Object> hm = null;
		Mvc06Service sv = new Mvc06Service();
		sc = new Scanner(System.in);
		Customer dto = null;

		int code;
		String name, email, tel;
		Double weight;

		while (true) {
			System.out.print("1:조건조회, 2:입력, 3:정보변경, 4:삭제, 9:종료 = ");
			String select = sc.next();

			// 종료
			if ("9".equals(select)) {
				hm = sv.cstEnd();
				break;
			}
			// 조건조회
			if ("1".equals(select)) {
				System.out.println("조회할 회원코드를 입력하세요");
				System.out.print("코드     >>");
				code = sc.nextInt();
				hm = sv.cstMulti(code);
			}
			// 입력
			if ("2".equals(select)) {
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
				dto = new Customer(code, name, email, tel, weight);
				hm = sv.cstInsert(dto);
			}
			// 정보변경
			if ("3".equals(select)) {
				System.out.println("변경할 고객번호를 입력하세요");
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
				dto = new Customer(code, name, email, tel, weight);
				hm = sv.cstUpdate(dto);
			}
			// 삭제
			if ("4".equals(select)) {
				System.out.println("삭제할 회원코드를 입력하세요");
				System.out.print("코드     >>");
				code = sc.nextInt();
				hm = sv.cstDelete(code);
			}
			output(hm);
		}
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