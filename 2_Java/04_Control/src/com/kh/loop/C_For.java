package com.kh.loop;

import java.util.Scanner;

public class C_For {
	
	Scanner sc = new Scanner(System.in);
	
	/* for문 (반복문)
	 * 초기식 : int형 사용
	 * for(초기식; 조건식; 증감식) {
	 * 		실행 코드
	 * }
	 * 
	 * - 주어진 횟수만큼 코드를 반복 실행하는 구문
	 * - 초기식 : 반복문이 수행될 때 단 한 번만 실행, 반복문 안에서 사용할 변수를 선언하고 초기값 대입
	 * - 조건식 : 결과가 true이면 실행 코드를 실행, false이면 실행하지 않고 반복문을 빠져나감
	 * - 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연산자 사용
	*/
	
	
	public void method1() {
		// 1~5 출력
		for(int i = 1; i <= 5; i++ ) {
			System.out.println(i);
		}
	}
	
	
	public void method2() {
		// 1~5 반대로 출력
		for(int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
	}
	
	public void method3() {
		// 1~10 사이의 홀수만 출력
		
		for(int i = 1; i<=10; i++) {
			if(i % 2 == 1) System.out.println(i);
		}
		
		System.out.println("------");
		
		
		// 다른 방법
		for(int i = 1; i<=10; i += 2) {
			System.out.println(i);
		}
		
		System.out.println("------");
		
		
		// 또 다른 방법
		
		/* continue 문
		 * - continue 문은 반복문 안에서 사용
		 * - 반복문 안에서 continue를 만나면 "현재 구문" 종료
		 * - 반복문을 빠져나가는건 아님, 다음 반복을 계속 수행
		 * */
		for(int i = 1; i<=10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}
		
	}
	
	public void method4() {
		// 1~10까지의 합계
		
		int sum = 0; // !변수 설정!
		
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
		
	}
	
	
	public void method5() {
		// 1부터 사용자가 입력한 수까지의 합계
		
		System.out.print("입력 숫자 : ");
		int num	= sc.nextInt();
		int sum = 0;
		
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	
	public void method6() {
		// 1부터 랜덤값까지의 합계
		
		/* 랜덤값
		 * java.lang.Math 클래스에서 제공하는 random() method 사용
		 * 호출할 때마다 매번 다른 랜덤값을 얻어낼 수 있음
		*/
		double random = Math.random(); // 0.0 <= random 범위 < 1.0 
		random = Math.random()*10; // 0.0 <= random < 10.0 : 범위 확장
		random = Math.random() *10 + 1; // 1.0 <= random < 11.0
		System.out.println("랜덤값 : "+(int)random); // int로 변환 -> 정수
		
		int num = (int) random; // 1~10까지의 랜덤값
		int sum = 0;

		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println(sum);
		
	}
	
	public void method7() {
		/* 사용자한테 입력받은 문자열을 세로로 출력
		 * 
		 * 사용자 입력 : Hello
		 * H => str.charAt(0)
		 * e
		 * l
		 * l
		 * o => str.charAt(str.length()-1)
		 * */
		
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		
		// 조건식 : i < str.length(); 이것도 가능
		for(int i = 0; i <= str.length()-1; i++) {
			System.out.println(str.charAt(i));
		}
		
		System.out.println("-------");
		
		
		// 다른 방법
		/* 향상된 for 문
		 * 
		 * for(데이터타입 변수 : 배열) {
		 * 		변수 : 배열의 값을 하나씩 가지고 옴
		 * }
		 * 
		 * 문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬 것
		 * - String.charAt(int index) : 인덱스에 있는 문자를 char 형식으로 반환
		 * - String.toCharArray() : 모든 문자가 들어 있는 char[] 형식의 데이터 반환
		 * */
		char[] arr = str.toCharArray(); // 문자배열로 변환
		for(char ch : arr) {
			System.out.println(ch);
		}
				
	}
	
	
	public void method8() {
		// 구구단 - 2단 출력
		
		/* 잘 안풀릴경우 미리 적어보기
		 * 2 x 1 = 2
		 * 2 x 2 = 4
		 * ...
		 * 2 x 9 = 18
		 * 
		 * 
		 * */
		
		for(int i = 1; i <= 9; i++) {
			System.out.printf("2 x %d = %d\n", i, 2*i);
		}
		
	}
	
	public void method9() {
		// 중첩 for문
		// 2~9단 출력
		for (int i = 2; i<= 9; i++) {
			for (int j = 1; j<=9; j++) {
				System.out.printf("%d x %d = %d\n", i, j, i*j);
			}
		}
	}	
	
	
	public void method10() {
		/*
		 * *****
		 * *****
		 * *****
		 * *****
		 * 
		 * */
		
		
		// i = 줄, j = *갯수
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");//5개까지 옆으로 붙기 print
			}
			System.out.println();// println : 5개 이후 줄바꿈
		}
		
		
	}
	
	public void method11() {
		
		/*
		 * 1****
		 * *2***
		 * **3**
		 * ***4*
		 * ****5
		 */
		
		// i = 줄 / j = 갯수 
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j<5; j++) {
				/* System.out.print("("+i + ", "+ j+")");
				 * 미리 위치 확인해보기 
				 값: (0, 0)(0, 1)(0, 2)(0, 3)(0, 4)
					(1, 0)(1, 1)(1, 2)(1, 3)(1, 4)
					(2, 0)(2, 1)(2, 2)(2, 3)(2, 4)
					(3, 0)(3, 1)(3, 2)(3, 3)(3, 4)
					(4, 0)(4, 1)(4, 2)(4, 3)(4, 4)
					=> i = j 일때마다 숫자
				*/
				if (i == j) {
					System.out.print(i+1);
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	
	
	public void method12() {
		/*
		 * *		i=0, j=0
		 * **		i=1, j=0, j=1
		 * ***		i=2, j=0, j=1, j=2
		 * ****		i=3, j=0, j=1, j=2, j=3
		 * *****	i=4, j=0, j=1, j=2, j=3, j=4
		 * ******	i=5, j=0, j=1, j=2, j=3, j=4, j=5
		 * */
		
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (j > i) {
					System.out.print("");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		// 풀이
		for(int i=0; i<6; i++) {
			for(int j =0; j <= i; j++) {
				System.out.println("*");
			}
			System.out.println();
		}
	}
	
	public void method13() {
		/*
		 *     *	i=0, j=0
		 *    **	i=1, j=0, j=1
		 *   ***	i=2, j=0, j=1, j=2
		 *  ****	i=3, j=0, j=1, j=2, j=3,
		 * ***** 	i=4, j=0, j=1, j=2, j=3, j=4
		 * */
		
		for (int i=0; i<5; i++) {
			for (int j=4; j>= 0; j--) {
				if (i < j) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		C_For c = new C_For();
//		c.method1();
//		c.method2();
//		c.method3();
//		c.method4();	
//		c.method5();
//		c.method6();
//		c.method7();
//		c.method8();
//		c.method9();
//		c.method10();
//		c.method11();
//		c.method12();
		c.method13();

	}

}
