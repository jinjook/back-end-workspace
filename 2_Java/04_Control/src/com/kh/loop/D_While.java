package com.kh.loop;

import java.util.Scanner;

public class D_While {
	
	Scanner sc = new Scanner(System.in);
	
	/* while 문
	 * 
	 * while(조건식) {
	 * 		조건이 true일 경우 계속 실행
	 * }
	*/

	public void method1() {
	// 1~5까지 출력 : for -> while
		
		for(int i=1; i<=5; i++) {
			System.out.println(i);
		}
		
		System.out.println("-----------");
		
		int i = 1; // 초기식
		while(i<=5) {
		// 조건식
			System.out.println(i);
			i++; // 증감식
		}
		// index 문제들은 for문 쓰는것 추천
	}
	
	
	/* 무한루프 & break문 
	 * 
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나감
	 * */
	
	public void method2() {
		while(true) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			System.out.println(num);
			if(num == 0) break;
		}
		
	}
	
	/* do {
	 * 		실행 코드
	 * } while(조건식);
	 * 
	 * - 조건과 상관없이 무조건 한 번은 실행
	 * - 거의 쓸일이 없음...
	 * */
	public void method3() {
		int number = 1;
		
		while(number == 0 ) {
			System.out.println("while");
		} // 조건에 맞지 않음 - 출력 x 
		
		do {
			System.out.println("do-while");
		} while(number == 0); // 조건이 맞지 않더라도 한번은 출력 
		
	}
	
	
	public void method4() {
		/* 숫자 맞히기 게임
		 * 1과 100 사이의 값을 입력해서 임의로 지정한(Random)값을 맞히면 게임 끝
		 * 게임이 끝나면 몇 번만에 맞혔는지 출력!
		 * 
		 * (예: 57)
		 * 1과 100 사이의 값 입력 > 35
		 * 더 큰 수를 입력하세요.
		 * 1과 100 사이의 값 입력 > 70
		 * 더 작은 수를 입력하세요.
		 * 1과 100 사이의 값 입력 > 57
		 * 3번 만에 맞혔습니다.
		 * */
		
		int random = (int)(Math.random() * 100 +1);
		int count = 0; // 밖에서 설정.........
		while(true) {
			count++;	
			System.out.print("1과 100 사이의 값 입력 > ");
			int num = sc.nextInt();
					
			if(num > random) {
				System.out.println("더 작은 수를 입력하세요.");
			} else if (num < random) {
				System.out.println("더 큰 수를 입력하세요.");
			} else {
				System.out.println(count +"번 만에 맞혔습니다.");
				break;
			} 
		} 
		
		
		
		/*
		// while (random != num1) 방법
		int num1 = 0;
		int count1 = 0;
		while (random != num1) {
			count1++;
			System.out.print("1과 100 사이의 값 입력 > ");
			num1 = sc.nextInt();
					
			if(num1 > random) {
				System.out.println("더 작은 수를 입력하세요.");
			} else if (num1 < random) {
				System.out.println("더 큰 수를 입력하세요.");
			} 
		}
		System.out.println(count1 +"번 만에 맞혔습니다.");
		*/
		
			
	}

	
	public void method5() {
		/* --------------------------------
		 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 * --------------------------------
		 * 선택 > 1
		 * 예금액 > 5000
		 * --------------------------------
		 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 * --------------------------------
		 * 선택 > 2
		 * 출금액 > 2000
		 * --------------------------------
		 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 * --------------------------------
		 * 선택 > 3
		 * 잔고 > 3000
		 * --------------------------------
		 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 * --------------------------------
		 * 선택 > 4
		 * 프로그램 종료
		 * */
		
		int won = 0; 
		int won1 = 0; // 금액이 저장되어야 잔고에서 쓸 수 있음. while안에 넣으면 값이 매번 초기화됨
		int balance = 0; // 잔고를 저장했을 경우, 
		boolean check = true; // switch 종료시키기 위해 사용
		while(true) {
			System.out.println("---------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("---------------------------------");
			
			System.out.print("선택 > ");
			int num = sc.nextInt();
			
			if(num == 1) {
				System.out.print("예금액 > ");
				won = sc.nextInt();
				// balance += sc.nextInt(); 잔고를 밖에 저장했을 경우
				/* 풀어 쓰면,
				 * int money = sc.nextInt ();
				 * balance += money; 
				 * */
			} else if (num == 2) {
				System.out.print("출금액 > ");
				won1 = sc.nextInt();
				// balance -= sc.nextInt(); 잔고를 밖에 저장했을 경우
			} else if (num == 3) {
				System.out.println("잔고 > "+ (won-won1));
				//System.out.println("잔고 > "+ balance); 잔고를 밖에 저장했을 경우
			} else if (num == 4) {
				System.out.println("프로그램 종료");
				break;
			}
			
			
			// switch문 사용
			switch(num) {
				case 1 :
					System.out.print("예금액 > ");
					balance += sc.nextInt();
					break;
				case 2 :
					System.out.print("출금액 > ");
					int ex = sc.nextInt();
					if(ex > balance) System.out.println("잔고가 부족합니다ㅠ");
					else balance -= ex;
					break;
				case 3 :
					System.out.println("잔고 > "+ balance);
					break;
				case 4 :
					System.out.println("프로그램 종료");
					check = false;
					break;
					// switch에 대한 break로, 프로그램 종료해도 while이 종료가 되지 않음 
					// 1. switch 밖에서 break한번 더 걸어주면 됨 if(num == 4) break;
					// 2. while의 조건식을 true가 아니라 select!=4로 바꾸기
					// 3. while 밖에 boolean check = true;를 걸고 case 4 에 check = false; 넣어주기
			}
			
			// if(num == 4) break;
		}
		
		
		
		
		
		
		
	}
		
	
	
	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
		d.method5();
		
		
		
		
	}

}



















