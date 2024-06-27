package com.kh.variable;

public class C_Printf {

	public static void main(String[] args) {
		
		// System.out.print(출력하고자 하는 값); - 출력만 함 (줄바꿈 x)
		// System.out.println(출력하고자 하는 값); - 출력 후 줄바꿈
		System.out.print("hello");
		System.out.println("hello"); // ln : 줄바꿈
		System.out.print("hello\n"); // \n : 동일하게 줄바꿈 됨
		
		System.out.println("-----------------------------");
		
		// System.out.printf("출력하고자 하는 형식(포맷)", 출력하고자 하는 값, 값, ...);
		// 출력하고자 하는 값들이 제시한 형식에 맞춰서 출력만 진행 
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20%
		System.out.print(iNum1 + "% "); // 연결은 무조건 + 연산자 사용
		System.out.print(iNum2 + "%\n");
		
		System.out.println(iNum1+"% "+iNum2+"%"); 
		
		/*
		 * 포맷에 쓰이는 키워드 *
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열 (문자도 가능)
		 */
		
		System.out.printf("%d%% %d%%", iNum1, iNum2); // %는 키워드표기할때와 겹치기 때문에 %를 와일드카드처럼 사용
		System.out.println();
		System.out.println("-----------------------");
		
		System.out.printf("%5d", iNum1); // 5칸 공간 확보 후 양수 오른쪽 정렬
		System.out.println();
		System.out.printf("%-5d\n", iNum2); // 5칸 공간 확보 후 음수 왼쪽 정렬
		System.out.println("-----------------------");
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		
		System.out.printf("%f\t%f\n", dNum1, dNum2); // 무조건 소수점 아래 6번째 자리까지 출력됨
		// \t :tab만큼 띄우기
		System.out.printf("%.3f\t%.2f", dNum1, dNum2); //%와f 사이에 '.원하는자릿수'
		System.out.println();
		System.out.println("-----------------------");
		
		char ch = 'a'; // !문자는 '' 사용!
		String str = "Hello"; // !문자열은 "" 사용!
		
		// a      Hello a 
		System.out.printf("%c\t%s %c", ch, str, ch);
		System.out.println();
		System.out.printf("%-8c%s %c\n", ch, str, ch);
		System.out.printf("%-8s%s %s\n", ch, str, ch);
		
		System.out.printf("%C %S", ch, str); // A HELLO : 모두 대문자로 출력
		
	}

}



















