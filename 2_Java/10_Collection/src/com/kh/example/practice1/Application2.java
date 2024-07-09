package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.kh.set.model.Person;

public class Application2 {

	public static void main(String[] args) {
		
		/* 연습용 */
		Application2 a = new Application2();
//		a.method();
		a.method1();
		
		
	}

	
	public void method()	{
		Set lotto = new HashSet();
		
		lotto.add(4);
		lotto.add(28);
		lotto.add(35);
		lotto.add(39);
		lotto.add(44);
		lotto.add(45);
		
		int count = 0;
		while(true) {
			
			Set mine = new HashSet();
			
			for (int i=0; i < 6; i++) {
				int random = (int)((Math.random()*45) + 1);
				mine.add(random);
				
				if (mine.size() == 6);
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
	
	
	public void method1() {
		
		Set mine = new HashSet();
				
		while(true) {
			int random = (int)((Math.random()*45) + 1);
			mine.add(random);
			if (mine.size() == 6)
			break;
		} 
		System.out.println(mine);
		System.out.println(mine.size());
		
		
		
		
			
	}}

