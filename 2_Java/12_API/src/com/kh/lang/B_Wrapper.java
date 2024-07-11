package com.kh.lang;

public class B_Wrapper {

	public static void main(String[] args) {
//		int -> Integer
		int iNum1 = 3;
		Integer int1 = new Integer(iNum1); // Deprecated : 기능은 있지만 권장하진 않는다는 뜻
		int1 = 3;
		// Boxing : 기본 자료형 -> Wrapper 클래스
		// UnBoxing : Wrapper 클래스 -> 기본 자료형 
		
//		double -> Double
		double dNum2 = 3.14;
		Double double2 = new Double(dNum2);
		double2 = 3.14;
		
//		char -> Character
		char ch3 = 'a';
		Character ch4 = new Character(ch3);
		ch4 = 'a';
		
		// String 과 Wrapper 클래스 간의 변경
		// 1. 문자열을 기본 자료형으로 변경 : parseXXX()
		int iNum = Integer.parseInt("20");
		double dNum = Double.parseDouble("34.78");
		
		// 2. 기본 자료형을 문자열로 변경 
		System.out.println(iNum + dNum); // 54.78 숫자가 더해짐
		
		// String의 valuOf() 사용
		String str1 = String.valueOf(iNum);
		String str2 = String.valueOf(dNum);
		
		System.out.println(str1 + str2); // 2034.78 그대로 붙여짐
		
		// Wrapper 클래스에서 제공하는 valueOf().toString() 사용
		String str3 = Integer.valueOf(iNum).toString();
		String str4 = Double.valueOf(dNum).toString();
		
		System.out.println(str3 + str4); // 2034.78 그대로 붙여짐
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
