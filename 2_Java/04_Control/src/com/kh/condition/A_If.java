package com.kh.condition;

import java.util.Scanner;

public class A_If {
	
	Scanner sc = new Scanner(System.in);
	
	/* If문
	 * 
	 * if(조건식) {
	 * 		조건식이 참(true)일 때 실행
	 * }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	 * 
	 */
	
	public void method1 ()	{
		
		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력
		
		System.out.print("성적 : ");
		int score = sc.nextInt();
		
		if(score >= 60){
			System.out.println("합격입니다");
		}
		
		// 한 줄만 들어갈때는 {}없이 이렇게도 사용 가능!
		if(score >= 60) System.out.println("합격입니다");
		
	}
	
	
	/* if-else 문
	 * 
	 * if(조건식) {
	 * 		조건식이 참(true)일 때 실행
	 * } else {
	 * 		조건식이 거짓(false)일 때 실행
	 * }
	 * 
	 */
	
	public void method2() {
		// 입력받은 성적이 60점 이상이면 "합격입니다"
		// 아니면 "불합격입니다"를 출력
		
		System.out.print("성적 : ");
		int scr = sc.nextInt();
		
		if(scr >= 60) {
			System.out.println("합격입니다");
		} else {
			System.out.println("불합격입니다");
		}
		
		//삼항연산자
		String result = scr>=60 ? "합격입니다" : "불합격입니다";
		System.out.println(result);
	}
	
	public void method3() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다"를 출력
		
		System.out.print("본인의 이름 : ");
		String name = sc.nextLine();
		
		System.out.println("name의 주소값 : " + System.identityHashCode(name)); // 403424356
		System.out.println("본인이름의 주소값 : " + System.identityHashCode("김먼지")); // 2008362258
		// name과 김먼지의 주소값이 다름
		
		
		if(name == "김먼지") {
			System.out.println("본인이다");
		} else {
			System.out.println("본인이 아니다");
		} // 본인이 아니다로 뜸..
		// java에서 대문자로 시작 = class => String은 class임. 값이 아닌 주소 값을 저장
		
		
		
		if(name.equals("김먼지")) {
			System.out.println("본인이다");
		} else {
			System.out.println("본인이 아니다");
		}
		
		
	}
	
	
	/* if - else if - else 문
	 * 
	 * if(조건식1) {
	 * 		조건식1이 참(true)일 때 실행
	 * } else if(조건식2) {
	 * 		조건식1이 거짓(false)이면서 조건식2이 참(true)일 때 실행
	 * } else {
	 * 		조건식1, 조건식2 모두 거짓(false)일 때 실행
	 * }
	 * 
	 *  - else if는 수가 제한이 없음
	 */
	public void method4() {
		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 "음수"출력
		
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		// 삼항연산자 사용
		String result = num > 0 ? "양수" : num == 0 ? "0이다" : "음수";
		System.out.println(result);
		
		// if문 사용 -> 중첩 가능! 가급적 좋은 코드는 아님
		if(num > 0) {
			System.out.println("양수");
		} else {
			if(num == 0) {
				System.out.println("0이다");
			} else {
				System.out.println("음수");
			}
		}
		
		// if-else if -else 사용
		if (num > 0) {
			System.out.println("양수");
		} else if (num == 0) {
			System.out.println("0이다");
		} else {
			System.out.println("음수");
		}
		
	}
	
	public void practice1() {
		/* 사용자에게 점수(0~100)를 입력받아서 점수별로 등급 출력
		 * -90점 이상은 A등급
		 * -90점 미만 80점 이상은 B등급
		 * -80점 미만 70점 이상은 C등급
		 * -70점 미만 60점 이상은 D등급
		 * -60점 미만 F등급
		*/
		
		System.out.print("점수(0~100) 입력 : ");
		int scr = sc.nextInt();
		
		if (scr >= 90) {
			System.out.println("A 등급");
		} else if (scr >= 80) {
			System.out.println("B 등급");
		} else if (scr >= 70) {
			System.out.println("C 등급");
		} else if (scr >= 60) {
			System.out.println("D 등급");
		} else {
			System.out.println("F 등급");
		}
		
		
		// 간단하게..
		String result = "";
		
		if (scr >= 90) {
			result = "A";
		} else if (scr >= 80) {
			result = "B";
		} else if (scr >= 70) {
			result = "C";
		} else if (scr >= 60) {
			result = "D";
		} else {
			result = "F";
		}
		
		System.out.println(result);
		
	}
	
	public void practice2() {
		/*
		세 정수를 입력했을 때 짝수만 출력
		num1 입력 : 3
		num2 입력 : 4
		num3 입력 : 6
		4
		6
		*/
		
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		System.out.print("정수3 : ");
		int num3 = sc.nextInt();
		
		if (num1 % 2 == 0) System.out.println(num1);
		if (num2 % 2 == 0) System.out.println(num2);
		if (num3 % 2 == 0) System.out.println(num3);

	}	
		
	
	public void practice3() {
		/* 정수 1개를 입력했을 때 음(minus)/양(plus)/0(zero), 짝(even)/홀(odd) 출력
		 * 
		 * 정수입력 : -3
		 * minus
		 * odd
		*/
		
		System.out.print("정수 입력 : ");
		int num	= sc.nextInt();
		
		String result = "";
		
		if(num > 0) {
			result = "plus";
		} else if (num == 0) {
			result = "zero";
		} else {
			result = "minus";
		}
		
		System.out.println(result); // result 출력 후 재사용 가능
		
		
		if (num == 0) {
			result = "";
		} else if (num % 2 == 0) {
			result = "even";
		} else {
			result = "odd";
		}
		
		System.out.println(result);	
		
	}
	
	
	public static void main(String[] args) {
		
		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.practice1();
//		a.practice2();
		a.practice3();
		

	}

	
	
	
	
	
	
	
	
}











































