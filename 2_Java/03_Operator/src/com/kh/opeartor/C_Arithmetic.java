package com.kh.opeartor;

public class C_Arithmetic {
	
	/* 산술 연산자
	 * + : 더하기
	 * - : 빼기
	 * * : 곱하기
	 * / : 나누기
	 * % : 나머지
	 */
	
	// main에서만 호출하기 때문에 꼭 main에 method를 담을 것!
	public static void main(String[] args) {
		
		C_Arithmetic c = new C_Arithmetic();
		c.method1();
		c.method2();
			

	}
	
	public void method1() {
		int num1 = 10;
		int num2 = 3;

		System.out.println("+ : " + (num1 + num2));
		System.out.println("- : " + (num1 - num2));
		System.out.println("* : " + (num1 * num2));
		System.out.println("/ : " + (num1 / num2));
		System.out.println("% : " + (num1 % num2));

	} 
	
	// 코드 정렬 깔끔하게 하고 싶다면 해당 영역 잡고 ctrl + shift + f

	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b; // a=6 , c = 16
		int d = c / a; // d = 2
		int e = c % a; // e = 4
		int f = e++; // f = 4, e = 5
		int g = (--b) + (d--); // b=9 d=1 g= 11
		int h = c-- * b; // c= 15 h= 16*9 = 144
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h);
		// 6+9/(14 / 4) * (11 - 2) % (6+144)

		// i 값은? 36
		
		
		
	}

}



