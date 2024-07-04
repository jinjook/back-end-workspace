package com.kh.practice;

import java.util.Scanner;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// static이 제일 먼저 올라감, main method가 제일 먼저 호출됨
		LoopPractice l = new LoopPractice(); // 객체 생성 했을 때 해당 클래스 변수/메서드가 올라감
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
//		l.method5();
		l.method6();

	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	
    	System.out.print("사용자 입력 : ");
    	int num = sc.nextInt();
    	
    	if(num > 0 && num <= 100) 
    		for (int i = num; i >0; i--) {
    		System.out.println(i);
    		}
    	
    	
    	
    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	// 끝이 안정해진 것 -> while문 사용
    	int sum = 0;
    	int num = 1;
    	
    	
    	/* while(sum >= 100) {
    		count++;
    		if(num % 2 == 0) {
    			num = (-num);
    		} else {
    			num = +num;
    		} sum += num;
    	} 
    	System.out.println(num);*/
    	
    	//풀이 
    	while(true) {
    		if(num % 2 == 0) {
    			sum -= num;
    		} else {
    			sum += num;
    		}
    		
    		if(sum >= 100) {
    			System.out.println(num);
    			break;
    		}
    		num++;
    	}
    	
    	// 풀이2 - while(sum < 100):100 이하일때까지만 돌다가 100 이상 되는 순간 내보내기
    	int num1 = 0;
    	while(sum < 100) {
    		num1++;
    		if(num1 % 2 == 0) {
    			sum -= num1;
    		} else {
    			sum += num1;
    		}
    	} System.out.println(num); // 바깥에서 출력
 
    }
    

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	
    	System.out.print("문자열 : ");
    	String str = sc.nextLine();
    	System.out.print("문자 : ");
    	char ch = sc.nextLine().charAt(0);
    	
		int count = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ch) count++;
		} 
		System.out.println(str+" 안에 포함된 "+ch+" 개수 : "+count);
		
		
		/* 향상된 for문 : for (값 : 배열)
		for( char s : str.toCharArray()) {
			if(ch == s) count++;
		}
		System.out.println(str+" 안에 포함된 "+ch+" 개수 : "+count);*/
		
    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	 
    	while(true) {
    		int random = (int)(Math.random()*11); 
    		if(random != 0 ) {
    		System.out.print(random);
    		sc.nextLine();
    		}
    		else {
    			System.out.println(random);
    			break;
    		}
    	}
    	    	
    	// 풀이
    	while(true) {
    		int random = (int)(Math.random()*11); 
    		System.out.println(random);
    		if(random == 0 ) break;
    	}
    	
    	
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	
    	int count1 = 0;
    	int count2 = 0;
    	int count3 = 0;
    	int count4 = 0;
    	int count5 = 0;
    	int count6 = 0;
    	int total = 0;
    	
    	while (true) {
    		total++;
    		int random = (int)(Math.random()*6 +1); 
    		
    		switch(random) {
    		case 1 : count1++;
    			break;
    		case 2 : count2++;
    			break;
    		case 3 : count3++;
    			break;
    		case 4 : count4++;
    			break;
    		case 5 : count5++;
    			break;
    		case 6 : count6++;
    			break;
    		}
        		if(total==10) break;
        		
    	}
    	System.out.println("1 : "+count1);
    	System.out.println("2 : "+count2);
    	System.out.println("3 : "+count3);
    	System.out.println("4 : "+count4);
    	System.out.println("5 : "+count5);
    	System.out.println("6 : "+count6);

    	
    	// 풀이 (배열 사용)
    	
    	int[] dice = new int[6];
    	
    	for(int i=0; i<10; i++) {
    		int random = (int) (Math.random() *6);
    		/* random : 0 --> dice[0]
    		 * random : 1 --> dice[1]
    		 * random값 => dice[]값
    		 * */
    		dice[random]++;
    	}
    	
    	for(int i=0; i<dice.length; i++) {
    		System.out.println((i+1)+" : "+ dice[i]);
    	}
    	
    }

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
	    
	    
    */
    public void method6() {
    	
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
    	int draw = 0;
    	int lose = 0;
    	int win = 0;
    	
    	while(true) {
    		System.out.print("가위바위보 : ");
    		String str = sc.nextLine();
    		
    		// 여기서부터 배열로 풀이
    		String Random = "";
    		int random = (int)(Math.random() * 3);
    		if(random == 0) Random="가위";
    		else if (random == 1) Random = "바위";
    		else Random = "보";
    		
    		System.out.println("컴퓨터 : "+Random);
    		System.out.println(name + " : "+ str);
    		
    		if (Random.equals(str)) {
    			System.out.println("비겼습니다.");
    			draw++;
    		} else if ((str.equals("가위")&& random == 1) || (str.equals("바위")&& random == 2) || (str.equals("보")&& random == 0)) {
    			System.out.println("졌습니다 ㅠㅠ");
    			lose++;
    		} else {
    			System.out.println("이겼습니다!");
    			win++;
    			break;
    		}
    	
    
    	
    	/* 0- 가위, 1-바위, 2- 보를 배열로 정리
    	 * String[] rps = {"가위", "바위", "보"};
    		int random = (int)(Math.random() * 3);
    		System.out.println("컴퓨터 : ", + rps[random]);
    		
    		System.out.println(name + " : " + str);
    		
    		* 배열에서 값으로 인덱스 찾기 -> 사용자가 입력한 값을 숫자로 변경해줌 
    		* 내가 입력한 가위바위보를 숫자로 변환해서 랜덤과 비교할 수 있도록 
    		int number = Arrays.asList(rps).indexOf(random); 
    		
    		if(random == number){
    			System.out.println("비겼습니다.");
    			draw++;
    		} else if((number == 0 && random == 2) 
    				|| (number == 1 && random == 0)
    				|| (number == 2 && random == 1) {
    			System.out.println("이겼습니다!");
    			win++;
    			break;
    		} else {
    			System.out.println("졌습니다 ㅠㅠ");
    			lose++;
    		}
    	 * */
    		
    		
    	} System.out.printf("비긴 횟수 : %d, 진 횟수 : %d, 이긴 횟수 : %d\n", draw, lose, win);

    }

}