package com.kh.step4;

import javax.swing.JOptionPane;

//프로세스 역할 - 두 스레드 간의 Communication은 프로세스의 자원으로 해야한다
public class InputThreadTest {
	
	boolean check = false; // 두 thread 의 공유 자원

	public static void main(String[] args) {
		
		InputThreadTest process = new InputThreadTest(); // 공유자원있는 객체 생성
		
		InputThread input = new InputThread(process);
		input.start();	
				
/*		// 1. 데이터 입력 작업 -> InputThread
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요.");
		System.out.println("입력하신 숫자는 " +input+ "입니다.");
*/		
		
		CountThread count = new CountThread(process);
		count.start();
		
/*		// 2. 카운팅 작업
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
*/
	}
	
	
	

}
