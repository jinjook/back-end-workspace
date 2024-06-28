package com.kh.opeartor;

import java.util.Scanner;

public class E_Logical {

	/* 논리 연산자
	 * - 두 개의 논리값을 연산해주는 연산자
	 * - 논리연산한 결과마저 논리값
	 * 
	 * 논리값 && 논리값 (and) : 왼쪽, 오른족 둘 다 true일 경우만 결과값이 true
	 * 논리값 || 논리값 (OR) : 왼쪽, 오른쪽 둘 중 하나라도 true일 경우 결과값이 true 
	 * 
	 */
	
	Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		E_Logical e = new E_Logical();
//		e.method1();
//		e.method2();
		e.practice();
	}
	
	
	public void method1() {
		// 사용자가 입력한 정수값이 1부터 100 사이의 값인지 확인
		System.out.print("정수값 입력해주세요 : ");
		int number = sc.nextInt();
		
		boolean result = 1<=number && number <= 100;
		System.out.println("1부터 100 사이의 값인가요? " + (1<=number && number <= 100));
		System.out.println("1부터 100 사이의 값인가요? " + result);
	}

	public void method2() {
		int number = 10;
		boolean result = false;
		
		// Short Cut Evaluation 
		
		// && 
		// true && true = true
		// true && false = false
		// false && false = false
		// false && false = false
		
		result = (number < 5) && (++number > 0); // 앞에서 이미 false라서 뒤쪽의 연산은 수행하지 x 
		
		// result? false / number? 10
		
		System.out.println(result);
		System.out.println(number);
		
		
		// || 
		// true || true = true
		// true || false = true
		// false || true = true
		// false || false = false
		
		result = (number < 20) || (++number > 0);
		// 이미 앞에서 true이기 때문에 결론은 true여서 뒤쪽 연산은 이뤄지지 않음
		System.out.println(result); // true
		System.out.println(number); // 10
		
	}
	
	/*
	 * 실습 문제 
	 * 
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기 
	 * A ~ Z : 65 ~ 90, a ~ z : 97 ~ 122
	 * */
	
	public void practice () {
		
		System.out.print("문자 값 : ");
		char ch = sc.nextLine().charAt(0);
	
		boolean check=(ch>=65 && ch<=90) || (ch>=97 && ch<=122);
		check =(ch>= 'A' && ch<= 'Z') || (ch>= 'a' && ch<= 'z');
		System.out.println(check);
		
	}
	
	
}



