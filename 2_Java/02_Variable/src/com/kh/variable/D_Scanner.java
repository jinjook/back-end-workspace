package com.kh.variable;

import java.util.Scanner;

public class D_Scanner {
	
	/*
	 * Scanner
	 * - 화면(Console)으로부터 데이터를 "입력"받는 클래스 
	 * 
	 * 1. import java.util.Scanner; 추가 => 클래스와 메서드 사이에 위치
	 * 
	 * 2. Scanner 객체 생성 (클래스 생성)
	 * 	  Scanner sc(=변수명) = new Scanner(System.in); -> 클래스 생성과 구조 동일
	 * 
	 * 3. Scanner method 사용
	 *    입력값이 
	 * 		- 문자열일 때 : sc.next() - 공백이 있을 경우 공백 이전까지 입력을 받음
	 * 					 sc.nextLine() - 공백 포함 엔터 전까지 입력을 받음
	 *      - 정수일 때 : sc.nextInt() 
	 *      - 실수일 때 : sc.nextFloat(), sc.nextDouble()
	 *      
	 *      => !sc.nextLine()만 사용하는 것을 권장! -> 얘만 enter 처리를 함
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 이름은 무엇입니까? > ");
		String name = sc.next(); // enter 처리 x
		// enter 처리안되고 입력한게 남아있는 상태에서 다음 addr을 만나는데, nextLine은 엔터까지라서 남아있던 enter까지 처리하고 끝내버림 
//		sc.nextLine(); // enter 처리를 해줌 
		
		System.out.print("당신의 나이는 몇살입니까? > ");
//		int age = sc.nextInt(); // enter 처리 x , enter 처리하는 애를 만나기 전까지는 문제 없음,,nextLine 만나는 순간 문제 생김
		
//		sc.nextLine(); // enter 처리 안하는 것 통틀어 마지막에 한번만 처리해주면 됨
		
		int age = Integer.parseInt(sc.nextLine());
		
/* => 간단하게 작업하기 위해 int age = sc.nextLine();으로 바꾸면 됨 but nextLine은 String이라서 에러 발생,
 * int age = Integer.parseInt(sc.nextLine()); -> String을 int로 바꿔줌
 */
		
		System.out.print("당신의 집은 어디십니까? > ");
		String addr = sc.nextLine();
			
		System.out.print("당신의 키는 몇입니까? (소수점 첫째 자리까지 입력하세요.) > ");
		double height = sc.nextDouble(); // enter 처리 x
		
/* => double height = sc.nextLine(); 으로 바꾸려면
 * double height = Double.parseDouble(sc.nextLine()); -> String을 double로 바꿔줌
 */
		
		sc.nextLine();
		
		System.out.print("당신의 성별은 무엇입니까? (남/여) > ");
		String input = sc.nextLine();
		char gender = input.charAt(0);
		
/* => char gender로 받고싶을 때, 뒤에 . 입력하면 관련 내용 뜸
 * 위 내용을 한줄로 표현하는 방법 : 
 * char gender = sc.nextLine().charAt(int index - 몇번째 값);
 */		
		
		System.out.println("당신의 이름은 "+name+"이고 나이는 "+age+"살, 키는 "+height+"cm, 성별은 "+gender+", 사는 곳은 "+addr+"이군요.");
		
		
		// printf로 변경
		System.out.printf("당신의 이름은 %s이고 나이는 %d살, 키는 %.1fcm, 성별은 %s, 사는 곳은 %s이군요.", name, age, height, gender, addr);
	}

}



























