package com.kh.step4;

public class CountThread extends Thread {

	InputThreadTest process;
	
	CountThread(InputThreadTest process){
		this.process = process;
	}
	
	public void run(){
		
		for(int i = 10; i > 0; i--) {
			if (process.check) break;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		if(!process.check) { // for 문이 끝났는데도 작성하지 않았을 때 (process.check == false)와 같은 뜻
			System.out.println("--10초 경과, 값 입력 불가--");
			System.exit(0); // 강제 종료
		}
		
	}
}
