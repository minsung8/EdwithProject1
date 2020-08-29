package kr.or.connect.edwithProject1.main;

import java.util.Scanner;

import kr.or.connect.edwithProject1.businessCardDAO.BusinessCardDAO;

public class Main {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BusinessCardDAO bdao = new BusinessCardDAO();
		
		while (true) {
			
			System.out.println("-------------------------------------------------");
			System.out.println("\n1. 명함입력");
			System.out.println("2. 명함검색");
			System.out.println("3. 종료");
			System.out.println("-------------------------------------------------");
			System.out.println("메뉴를 입력하세요 : ");

			String temp = sc.nextLine();
			
			if (temp.equals("1")) {
				bdao.addCard(sc);
			} else if (temp.equals("2")) {
				bdao.getCard(sc);
			} else if (temp.equals("3")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
			
		}
		
	}


	
	 

}
