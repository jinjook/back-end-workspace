package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;

public class Application {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 입력 받는 곳 : 여기는 controller 나 model 에 직접 접근 x
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		System.out.print("개수 : ");
		int numOf = Integer.parseInt(sc.nextLine());
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		
		// 생성자 호출 -> 기본 생성자가 만들어짐 / 서버에 전달할때는 controller로
		SnackController controller = new SnackController(); 
		
		// 서버한테 요청해서 응답받은 결과를 다시 화면으로 
		System.out.println(controller.saveData(kind, name, flavor, numOf, price));
		System.out.println(controller.confirmData());
	}

}
