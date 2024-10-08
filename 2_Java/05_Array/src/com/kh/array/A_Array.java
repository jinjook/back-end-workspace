package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class A_Array {
	
	Scanner sc = new Scanner(System.in);

	/* 변수 : 하나의 공간에 하나의 값을 담음
	 * 배열 : 하나의 공간에 "여러개의 값"(같은 자료형의 값)을 담음
	 * 
	 * 배열의 선언
	 * 자료형[] 배열명;
	 * 자료형 배열명[];
	 * 
	 * - 배열을 선언한다고 해서 값을 저장할 공간이 생성되는 것이 아니라 배열을 다루는데 필요한 변수가 생성됨
	 * 
	 * 배열의 초기화
	 * 배열명 = new 자료형[배열크기];
	 * - 생성된 배열에 처음으로 값을 저장
	 * 
	 * 배열의 선언과 초기화 동시 진행
	 * 자료형[] 배열명 = new 자료형[배열크기];
	 * */
	
	
	 // 숫자 배열 -> 일일이 지정하기
	public void method1() {
		
		int[] nums = new int[5]; // 배열 크기 반드시 지정해야함
		System.out.println(nums); // [I@65ae6ba4 : 주소값 
		
		// 배열 생성하고 해당 값들은 초기화하지 않은 상태 -> 기본값이 들어감
		// 기본값 => 정수형 : 0, 실수형 : 0.0, 문자형 : \u0000, 논리형 : false, 참조형 : null
		
		System.out.println(nums[0]); // 0 : 배열의 0번째
		System.out.println(nums[1]); // 0 : 배열의 1번째
		System.out.println(nums[2]); // 0
		System.out.println(nums[3]); // 0
		System.out.println(nums[4]); // 0 
		// 배열의 공간만 만들었을 뿐, 값을 넣지 않았기 때문에 값이 모두 기본값(0)
	
		nums[0] = 100;
		nums[1] = 70;
		nums[2] = 90;
		nums[3] = 80;
		nums[4] = 60;
		
		System.out.println(nums[0]); 
		System.out.println(nums[1]); 
		System.out.println(nums[2]); 
		System.out.println(nums[3]); 
		System.out.println(nums[4]);
	
	}
	
	//배열 선언과 동시에 값들 초기화
	public void method2() {
		int[] nums = {100, 70, 90, 80, 60};
		
		System.out.println(nums[0]); 
		System.out.println(nums[1]); 
		System.out.println(nums[2]); 
		System.out.println(nums[3]); 
		System.out.println(nums[4]);
		
		//반복문
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		//향상된 for문
		for(int value : nums) {
			System.out.println(value);
		}
	
	}
	
	public void method3() {
		/* 3명의 키를 입력받아 배열에 저장하고 3명의 키의 평균값을 구하시오
		 * 키 입력 > 180
		 * 키 입력 > 177.3
		 * 키 입력 > 168.2
		 * 175.2
		 * */
		
		double[] arr = new double[3];
		double sum = 0;
		for(int i=0; i<arr.length; i++) {
			System.out.print("키 입력 > ");
			arr[i] = sc.nextDouble(); // 배열에 바로 입력
			sum += arr[i];
		}
		
		// System.out.println(Arrays.toString(arr)); 배열 형태로 확인
		
		System.out.printf("%.1f", sum/arr.length);
				
	}
	
	// 배열의 복사
	// 1. 얕은 복사 : 배열의 주소만 복사
	public void method4() {
		
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = number;
		
		copy[1] = 20; // 같은 주소를 사용해서 number와 같이 바뀜
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
	}
	
	
	// 2. 깊은 복사 : 동일한 새로운 배열을 하나 생성해서 내부 값들도 함께 복사
	// 1) for 문을 이용한 깊은 복사
	public void method5() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = new int[number.length]; // 인덱스 동일해짐
		
		for (int i=0; i < number.length; i++) {
			copy[i]=number[i];
		}
		
		copy[1] = 20; // 새로 생성해서 값 복사 -> copy값만 바뀜
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
		
	}
	
	// 2) System 클래스에서 제공하는 arraycopy() 메서드를 이용한 깊은 복사 
	//	  System.arraycopy(원본배열, 복사시작인덱스, 복사본배열, 복사시작인덱스, 복사할길이);
	public void method6() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = new int[number.length];
		
		System.arraycopy(number, 0, copy, 0, number.length);
		
		copy[2] = 30; // 새로 생성해서 값 복사 -> copy값만 바뀜
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
	}
	
	// 3) Arrays 클래스에서 제공하는 copyOf() 메서드를 이용한 깊은 복사
	//	  Arrays.copyOf(원본배열, 복사본배열길이);
	public void method7() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = Arrays.copyOf(number, number.length); // 새로만들기 하면서 바로 적용 가능
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
		
	}
	
	// 4) 배열의 clone() 메서드를 이용한 깊은 복사 (얘만 알아도 됨!-제일 심플)
	public void method8() {
		int[] number = {1, 2, 3, 4, 5};
		int[] copy = number.clone();
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
	}
	
	
	public static void main(String[] args) {
		A_Array a = new A_Array();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.method5();
//		a.method6();
//		a.method7();
		a.method8();
		
		
		
	}

}



































