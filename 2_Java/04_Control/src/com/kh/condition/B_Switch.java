package com.kh.condition;

import java.util.Scanner;

public class B_Switch {
	
	Scanner sc = new Scanner(System.in);
	
	/* switch문
	 * 
	 * switch(조건식) {
	 * 		case 값1 :
	 * 			조건식의 결과가 값1과 같은 경우 실행
	 * 			break;
	 * 		case 값2 : 
	 * 			조건식의 결과가 값2와 같은 경우 실행
	 * 			break;
	 * 		default : 
	 * 			조건식의 결과가 일치하는 case문이 없을 때 실행
	 * }
	 * 
	 * - case문의 수는 제한이 없음
	 * - 조건식 결과는 정수, 문자, 문자열이어야함
	 * - 조건문을 빠져나가려면 break가 필요
	 * - default 문은 생략 가능
	*/
	public void method1() {
		/*
		 * 숫자를 입력받아
		 * 1일 경우 "빨간색입니다"
		 * 2일 경우 "파란색입니다"
		 * 3일 경우 "초록색입니다"
		 * 잘못입력했을 경우 "잘못입력했습니다" 
		*/
		
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		String result = "";
		switch (num) {
			case 1:
				result = "빨간색입니다";
				break;
			case 2:
				result = "파란색입니다";
				break;
			case 3:
				result = "초록색입니다";
				break;
			default:
				result = "잘못입력했습니다";
		}
		
		System.out.println(result);
	}
	
	
	public void practice1() {
		/*
		 * 주민번호를 입력받아 "남자"인지 "여자"인지 출력 (그 외에는 "사람이 아니다")
		 * 주민번호 입력 : 100000-3000000
		 * 남자
		 * */
		
		System.out.print("주민번호 입력 : ");
		char no = sc.nextLine().charAt(7);
		String result = "";
		
		
		switch (no) {
			case '1' :  // 그냥 1로 넣으면 유니코드로 인식됨 
				result = "남자";
				break;
			case '3' : 
				result = "남자";
				break;
			case '2' :
				result = "여자";
				break;
			case '4' :
				result = "여자";
				break;
			default :
				result = "사람이 아니다";
		}
		System.out.println(result);
		
		// case는 무조건 조건식과 일치해야만 함. 아래 방법도 가능
		switch (no) {
			case '1' : 
			case '3' :
				result = "남자";
				break;
			case '2' :
			case '4' :
				result = "여자";
				break;
			default :
				result = "사람이 아니다";
	}
	System.out.println(result);
	
	// 또 다른 방법 
	// String.valueOf : 문자열로 변환
	// Integer.parseInt : 정수로 변환 -> ''필요없어짐
		switch (Integer.parseInt(String.valueOf(no))) {
			case 1 : 
			case 3 :
				result = "남자";
				break;
			case 2 :
			case 4 :
				result = "여자";
				break;
			default :
				result = "사람이 아니다";
		}
		System.out.println(result);
	
	}
	
	public void practice2() {
		
		/* 등급별 권한
		 * 1 : 관리권한, 글쓰기권한, 읽기권한
		 * 2 : 글쓰기권한, 읽기권한
		 * 3 : 읽기권한
		 * 
		 * 등급 입력 : 1
		 * 관리권한
		 * 글쓰기권한
		 * 읽기권한
		*/
		
		System.out.print("등급 입력 : ");
		int grade = sc.nextInt();
		
		switch (grade) {
			case 1 : 
				System.out.println("관리권한");
			case 2 :
				System.out.println("글쓰기권한");
			case 3 :
				System.out.println("읽기권한");
		}
			
		
		// result는 변수에 계속해서 담아내는 게 아니라 해당 값을 변경하는 거라 마지막 값만 출력
		// 추가를 하고 싶다면 String result += ""; <-- 이런 식으로 복합대입연산자 사용
		String result = "";
		
		switch (grade) {
		case 1 : 
			result += "관리권한 ";
		case 2 :
			result += "글쓰기권한 ";
		case 3 :
			result += "읽기권한";
	}
		
		System.out.println(result);
		
	}
	
	
	
	public static void main(String[] args) {
		B_Switch b = new B_Switch();
//		b.method1();
//		b.practice1();
		b.practice2();

	}

}



















