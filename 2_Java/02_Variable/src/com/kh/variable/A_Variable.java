package com.kh.variable;

public class A_Variable {
	
	/*
	 * 변수(Variable) : 값을 저장하는 "공간"
	 */
	
	public static void main(String[] args) {
		
		A_Variable variable = new A_Variable();
		// 클래스     변수명    =>  실행할 method가 있는 클래스를 생성 (new)
		
//		variable.printValue(); 생성한 클래스로 method 실행 (호출)
//		variable.variableTest();
		variable.constant();
		
	}
	
	public void printValue() {
		
		// 원의 둘레와 원의 넓이를 출력
		// 원의 둘레 = 반지름 x 2 x 3.141592...
		// 원의 넓이 = 반지름 x 반지름 x 3.141592...
		
		// 변수를 사용하지 않고 출력 (일일이 작성)
		System.out.println(30 * 2 * 3.141592); // syso 입력 후 ctrl+space bar
		System.out.println(30 * 30 * 3.141592); // 두 값을 호출해야함
		
		System.out.println("--------------------------------");
		
		// 변수를 사용해서 출력 (편의성)
		int r = 30; // 반지름 변수 지정
		double pi = 3.141592; // 소수점을 포함한 실수를 담음

		System.out.println(r * 2 * pi);
		System.out.println(r * r * pi);
	}
	
	public void variableTest() {
		/*
		 * * 변수의 선언
		 * 
		 *   자료형 변수명;
		 *   - 자료형 : 어떤 값을 저장할지, 어떤 크기의 메모리를 할당받을지에 대한 정보
		 *   - 변수명 : 변수의 이름으로 값을 읽고, 쓰고, 지우는 작업을 할 때 사용
		 *   
		 * * 변수의 초기화
		 *   
		 *   변수명 = 값;
		 *   - 변수에 처음으로 값을 저장하는 것
		 *   - '='는 오른쪽 값을 왼쪽 변수에 대입(저장)하는 연산자
		 */
		
		// * 기본 자료형(Primitive type) : 실제 값을 저장, 
		// ** stack 메모리에 생성된 공간에 실제 변수값이 저장되는 형태
		// 1. 논리형 : 1byte
		boolean isTrue; // 변수 선언 (boolean을 담을 수 있는 변수 isTrue 선언)
		isTrue = true; // 변수 초기화
		
		boolean isFalse = false; // 변수 선언과 함께 초기화 
		
		// 2. 문자형 : 2byte
		char ch = 'a'; // 초기화 
//		ch = 'ab'; 에러 발생 - 한글자만 올 수 있음 
//		주석 단축키 : ctrl + /
		
		// 3. 정수형
		byte bNum = 1; // 1byte(=8bit = 2^8 = 256 = -128~127 영역 -> 128은 들어갈 수 x)
//		bNum = 128; 에러 발생 - 미스매치 : 데이터 공간이 다름, 공간이 넘침 (= 오버플로우 Overflow)
		short sNum = 128; // short (=2byte = 16bit = 2^16)
		int iNum = 922337283; // 4byte (=32bit) - 기본
		long lNum = 922337283458L; // 8byte, 숫자 뒤에 l/L 둘중에 하나 들어가야함
		
		System.out.println(lNum);
		
		// 4. 실수형
		float fNum = 1.2F; // 4byte  - 숫자 뒤에 F(f)를 입력해야함
		double dNum = 1.2; // 8byte - 기본
		
		System.out.println(fNum);
		
		// * 참조 자료형 : 4byte, 기본형을 제외한 나머지 (class), 주소 값을 저장
		// ** 실제 데이터 값은 Heap 메모리에 저장하고, stack 메모리 변수 공간에는 실제 변수값이 저장된 heap 메모리의 위치값을 저장
		String name = "장영태";
		String name2 = new String("장영태");
		System.out.println(name2);
		
		// 변수의 네이밍 규칙
		// 1. 대소문자 구분한다. -> 다 다르게 인식 
		int number;
		int NUMBER; 
		int Number;
//		String number; 자료형이 달라도 변수명이 같으면 에러 발생
		
		// 2. 숫자로 '시작'하면 안된다.
//		int 1age; 오류발생
		int a2g3e4; // 섞이는건 가능
		
		// 3. 특수 문자는 '_', '$' 두가지만 사용 가능하다.
		int _age; // 위치는 상관x
		int age$;
//		int %age; 오류발생
//		int age@; 오류발생

		// 4. 예약어(Reserved word)를 사용하면 안된다.
//		int public; public도 예약어, 예약어는 색이 다름
//		int void;
//		int int;
		int class2; 
		
		// 5. (권장사항-안지킨다고 에러가 나진 않음) 낙타표기법(카멜케이스)
		// 첫글자는 항상 소문자 (클래스랑 구분짓기 위해서), 뒤에 여러 단어가 오면 대문자로 구분
		
		int maxnumber;
		int max_number; // 스네이크 기범 - 주로 파이썬에서 사용
		int maxNumber; // 권장
		
	}
	
	public void constant() {
		
		/*
		 * 상수 (값이 변할 수 x)
		 * 
		 * final 자료형 변수명; 
		 * 
		 * - 변하지 않는 값으로 특정 변수의 값이 변경되는 걸 원하지 않을 때 사용
		 * - 초기화 이후에는 값을 변경할 수 없다
		 * - 상수의 네이밍 규칙은 대문자로 표기 ex.AGE -> 뒤에 여러 단어가 오면 _로 구분 ex.MAX_AGE
		 */
		int age = 20;
		age = 25; 
		System.out.println(age);
		
		final int AGE = 30;
//		AGE = 35; 에러발생
		System.out.println(AGE);
	
	}

}






















