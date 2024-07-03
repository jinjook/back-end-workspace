package com.kh.step4;

import java.util.Arrays;

import com.kh.step4.model.Car;

public class Application {

	public static void main(String[] args) {

		Car c = new Car(); // 생성자가 하나라도 있으면 컴파일러는 기본 생성자를 추가하지 않음 -> 기본생성자 만들어줘야함
		
		/* private라서 쓸수업서..
		c.color = "red";
		c.gearType = "auto";
		c.door = 4;
		*/ 
		
		Car car1 = new Car("White", "auto", 4); // 매개변수 들어간 생성자로 호출됨
		Car car2 = new Car("black", "manual"); // 에러 - door 없는걸로 새로 생성하면 됨
		
		System.out.println(car1); // 주소값이 뜸 -> toString을 만들면 됨
		System.out.println(car2); // 주소값이 뜸
		
		
		
		
		
		
	}
	
	/* 오버로딩 : 한 클래스 내에 동일한 이름의 method를 매개변수의 자료형과 개수, 순서가 다르게 작성되어야 함
	 * */ 
	void test() {}  
	void test(int a) {} // 동일한 이름이지만 매개변수가 있고/없고 차이로 다르게 인식. 변수명이 다른건 상관없음
	void test(int b, String s) {} // 자료형이 달라서 오버로딩 가능
	void test(String s, int b) {} // 순서가 달라서 오버로딩 가능
	void test(int a, int b) {}	// 개수가 달라서 오버로딩 가능
	
	
	

}
