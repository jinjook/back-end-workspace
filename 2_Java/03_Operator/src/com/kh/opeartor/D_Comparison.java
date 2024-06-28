package com.kh.opeartor;

import java.util.Scanner;

public class D_Comparison {

	public static void main(String[] args) {
		
		/* 비교 연산자
		 * a < b : a가 b보다 작은가?
		 * a > b : a가 b보다 큰가?
		 * a <= b : a가 b보다 작거나 같은가?
		 * a >= b : a가 b보다 크거나 같은가?
		 * a == b : a와 b가 같은가?
		 * a != b : a와 b가 같지 않은가?
		 * 
		 * - 비교 연산의 조건을 만족하면 true, 만족하지 않으면 false
		 */
		
		D_Comparison d = new D_Comparison();
//		d.method1();
		d.method2();

	}
	
	public void method1() {
		int a = 10;
		int b = 25;
		
		System.out.println(a == b); // false
		System.out.println(a <= b); // true
		
		boolean result = a > b; 
		System.out.println(result); // false
		
		System.out.println((a*2) > (b/5)); // true
		
		// 짝수와 홀수 - 2로 나누었을 때 나머지로 구분
		System.out.println("a가 짝수인가? : "+(a % 2 == 0));
		System.out.println("b가 홀수인가? : "+(b % 2 != 0)); 
		System.out.println("b가 홀수인가? : "+!(b % 2 == 0)); 
		System.out.println("b가 홀수인가? : "+(b % 2 == 1)); 
	}

	
	public void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 정수 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두 번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		// 첫번재 수가 두번째 수보다 큽니까?
		System.out.println("첫번재 수가 두번째 수보다 큽니까? "+(num1 > num2));
		
		// 첫번째 수가 짝수입니까?
		System.out.println("첫번째 수가 짝수입니까? "+(num1 % 2 == 0));
		
		System.out.println( num2 > 'A' ); // A~Z : 65~90, a~z = 97~122
				
	}
}



