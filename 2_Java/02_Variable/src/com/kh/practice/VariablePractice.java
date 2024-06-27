package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	public static void main(String[] args) {

		VariablePractice method = new VariablePractice();
//		method.method1();
//		method.method2();
//		method.method3();
//		method.method4();
//		method.method5();
		method.method6();
		method.method7();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		
		int adult = 10000;
		int student = 7000;
		
		System.out.println(adult *2 + student *3 +"원");
		System.out.println("-------------------------");
		
	}
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		int t = x;
		
		x = y;
		y = z;
		z = t;
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
		
		System.out.println("-------------------------");
	}

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 1 > ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("정수 2 > ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("합 : "+ (num1+num2)+", 차 : "+ (num1-num2) + ", 곱 : "+ num1*num2 +", 나누기 : "+ num1/num2 );
		
		System.out.println("-------------------------");

	}

	/*
	 * 키보드로 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가로 : ");
		double width = Double.parseDouble(sc.nextLine());
		
		System.out.println("세로 : ");
		double height = Double.parseDouble(sc.nextLine());
		
		System.out.println("면적 : "+ width*height + ", 둘레 : "+ (width+height)*2);
		
		System.out.println("-------------------------");

	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요 : ");
		String input = sc.nextLine();
		char word1 = input.charAt(0);
		char word2 = input.charAt(1);
		char word3 = input.charAt(input.length()-1);
		
		
		System.out.printf("첫번째 문자 : %c, 두번째 문자 : %c, 마지막 문자 : %c",word1, word2, word3);
		System.out.println();
		System.out.println("-------------------------");
	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자 : ");
		char code = sc.nextLine().charAt(0);
		
		int code1 = code;
		int code2 = code1 + 1;
		char code3 = (char)code2;
		
		
		System.out.println(code+" unicode : "+code1+", "+code3+" unicode : "+code2);
		System.out.println("-------------------------");

	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 : ");
		double kr = Double.parseDouble(sc.nextLine());
		
		System.out.println("영어 : ");
		double en = Double.parseDouble(sc.nextLine());
		
		System.out.println("수학 : ");
		double math = Double.parseDouble(sc.nextLine());
		
		
		double sum = kr+en+math;
		double avg = (kr+en+math)/3;
		
		System.out.printf("총점 : %.0f, 평균 : %.2f", sum, avg);
		

	}

}
