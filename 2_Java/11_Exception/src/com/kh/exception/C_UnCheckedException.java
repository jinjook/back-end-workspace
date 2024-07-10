package com.kh.exception;

public class C_UnCheckedException {
	
	/* UnCheckedException
	 * - RuntimeException을 상속하고 있는 예외들
	 * - 컴파일 시 예외 처리 코드가 있는지 검사하지 않는 예외
	 * - RuntimeException의 경우 프로그램 실행할 때 문제가 발생될 것을
	 * 	 충분히 예측 가능해서 조건문 등을 통해 처리 가능
	 * */
	
	//ArrayIndexOutOfBoundException
	// 배열의 접근에 잘못된 인덱스 값을 사용하는 경우 예외 발생
	public void method1() {
		String[] str = {"Hello Java", "Nice to meet you", "No I mean It"};
		
		// index 3이 없는 에러
		try {
		for(int i=0; i <= 3; i++) {
			System.out.println(str[i]);
			} 
		} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
		}
				
	}	
	
	// NegativeArraySizeException
	// 배열 크기를 음수로 지정한 경우 예외 발생
	public void method2() {
		try {
			int[] arr = new int[-3]; // 음수 -> 에러요소
		} catch(NegativeArraySizeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// ArithmeticException
	// 나누기 연산에서 분모가 0인 경우 예외 발생
	public void method3() {
		try {
			int result = 10/0;
		} catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("예외 발생 여부와 상관없이 무조건 실행");
			// 오류없어서 catch 할것이 없어도 무조건 실행되는 부분
		}
			
	}
	
	// NullPointerException
	// null 인 참조 변수로 객체의 멤버 참조 시도 시 예외 발생
	public void method4() {
		try {
			String str = null;
			System.out.println(str.length()); // 값이 null이라 길이를 구할 수 없음
		} catch(NullPointerException e) { // 상위 클래스인 Exception으로 넣을 수 있음 (Exception e)
			System.out.println(e.getMessage());
			// Cannot invoke "String.length()" because "str" is null
		}
		
	}
	
	
	public static void main(String[] args) {
		C_UnCheckedException c = new C_UnCheckedException();
//		c.method1();
//		c.method2();
//		c.method3();
		c.method4();
	}

}