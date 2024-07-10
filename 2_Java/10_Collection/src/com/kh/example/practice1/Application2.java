package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.kh.set.model.Person;

public class Application2 {

	/* 풀이 */
	public static void main(String[] args) {
		
		ArrayList<Integer> lotto = new ArrayList<>();
		//<> : int 쓰려면 Integer를 넣어야함
		
		// 중복제거(if 사용) + 6개 갯수 채우기(while 사용) -> 2등 당첨+보너스 하려면 번호 하나 더 필요함 -> 1개 더 추가
		while(lotto.size() < 7){
			int num = (int) (Math.random() * 45 +1);
			if(!lotto.contains(num)) { // contains : 포함되어있는 숫자 확인
				lotto.add(num); // 포함되어있지 않은 숫자면 add
			}
		}
		
		// index값 0~6까지 범위 지정해서 로또 번호 6개 따로 보너스 번호 따로 분리
		List<Integer> lottoList = lotto.subList(0, 6);
		int bonus = lotto.get(6);
				
		int count = 0;
		while(true) {
			
			count++;
			
			ArrayList<Integer> myLotto = new ArrayList<>();
			
			while(myLotto.size() < 6) {
				int num = (int) (Math.random() *45 +1);
				if(!myLotto.contains(num)) {
					myLotto.add(num);
				}
			}
			
			System.out.println("로또 번호 : " +lottoList);
			System.out.println("내 번호 : " + myLotto);
			
			Collections.sort(lottoList);
			Collections.sort(myLotto);
			
			// 멈추는 조건 : 로또번호와 내번호가 정확히 일치 -> 1등 당첨
			if(lottoList.equals(myLotto)) {
				System.out.println("1등 당첨, 횟수 : "+count);
				break;
			}
			
			// 2등 당첨 : 번호 5개 일치 + 보너스 번호 일치, 3등 당첨 : 번호 5개 일치
			int match = 0;
			
			for(Integer num : lottoList) {
				if(myLotto.contains(num)){
					match++;
				}
			}
			if(match == 5) {
				if(myLotto.contains(bonus)) {
					System.out.println("2등 당첨, 보너스 번호 : "+bonus+", 횟수 : "+ count);
					break;
				} else {
					System.out.println("3등 당첨, 횟수 : "+count);
					break;
				} 
			} else if(match == 4) {
				System.out.println("4등 당첨, 횟수 : "+count);
				break;
			} else if (match == 3) {
				System.out.println("5등 당첨, 횟수 : "+count);
				break;
			}
			
		}
		
	}

}

