package com.kh.example.practice1;

import java.util.HashSet;
import java.util.Set;

public class Application {

	public static void main(String[] args) {
		
	Set lotto = new HashSet();
	while(true) {
		int random = (int)((Math.random()*45) + 1);
		lotto.add(random);
		if (lotto.size() == 6)
		break;
	} 
		
		int count = 0;
		while(true) {
			
			Set mine = new HashSet();
			
			while(true) {
				int random = (int)((Math.random()*45) + 1);
				mine.add(random);
				if (mine.size() == 6)
				break;
			} 
					
			if(lotto.equals(mine)) {
			System.out.println("로또 번호 : "+lotto);
			System.out.println("내 번호 : " + mine);
			break;
			} else {
				System.out.println("로또 번호 : "+lotto);
				System.out.println("내 번호 : " + mine);
				count++;
			}	
		}
		System.out.println("횟수 : "+count);
		
	}

}
