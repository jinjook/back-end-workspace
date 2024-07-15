package com.kh.step3;

import java.awt.Toolkit;

public class BeepPrintTest {

	public static void main(String[] args) {
		
		TextThread text = new TextThread();
		text.start();
		
		// 경고음 5번 울리는 작업
		Toolkit tool = Toolkit.getDefaultToolkit();
		
		for(int i = 0; i < 5; i++) {
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
/*		// 띵띵띵띵띵을 5번 출력하는 작업
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		// 굳이 따로 만들 필요 없이 하나는 여기서 구현해도 됨
		SoundThread sound = new SoundThread();
		sound.start();
*/
		
	}

}
