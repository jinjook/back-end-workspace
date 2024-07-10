package com.kh.exception;

public class A_TryCatch {
	
	/* 컴파일 에러(compile-time error) : 컴파일 시에 발생하는 에러 (실행하기전부터 발생하는 에러)
	 * 런타임 에러(runtime error) : 실행 시에 발생하는 에러 (console에서 보이는 에러) 
	 * 논리적 에러(logical error) : 실행은 되지만, 의도와 다르게 동작 (원하는 값이 나오지 않음)
	 * 
	 * # 런타임 에러 두가지
	 * - 에러 (error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
	 * - 예외 (exception) : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
	 * 
	 * 에러는 메모리 부족(OutOfMemoryError)이나 스택오버플로우(StackOverflowError)와 같이 
	 * 		일단 발생하면 복구 할 수 없는 심각한 오류
	 * 예외는 발생하더라도 수습될 수 있는 비교적 덜 심각한 것
	 * 
	 * Object -> Throwable -> Exception / Error
	 * 
	 * Exception --> 
	 * 					IOException - FileNotFoundException, SocketException
	 * 					RuntimeException - ArithmeticException, IndexOutofBoundsException
	 * 
	 * # try ~ catch 구문
	 * 
	 * try {
	 * 
	 * 	  예외가 발생할 가능성이 있는 코드들 
	 * 
	 * } catch(예외클래스 예외변수명) {
	 * 
	 * 	  try에서 예외가 발생하면 실행을 멈추고 catch로 들어와서 예외 처리 코드 실행	
	 * 
	 * } finally {
	 *
	 * 	  예외가 발생하거나 발생하지 않든 무조건 실행되는 코드들 (finally 구문은 생략가능)
	 * 	  close().. // 반납 -- finally는 주로 자원을 반납하는 코드 
	 * 
	 * }
	 * */

	public static void main(String[] args) {
		
		try {
			
			throw new Exception(); // 고의로 예외 발생
		
		} catch(Exception e) {
			// printStackTrace : 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메세지를 화면에 출력
//			e.printStackTrace();
			// getMessage : 발생한 예외클래스의 객체에 저장된 메시지를 얻을 수 있음
//			System.out.println(e.getMessage()); // null
			// 비워버리면 에러 메시지 안뜸 
		}
		
		System.out.println("Hello!");
		
	}

}
