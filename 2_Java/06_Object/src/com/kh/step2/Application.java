package com.kh.step2;

import com.kh.step2.model.Card;

public class Application {

	public static void main(String[] args) {
		//클래스 변수는 객체 생성 없이 바로 접근 가능
		System.out.println(Card.width);
		System.out.println(Card.height);
		
		Card card1 = new Card();
		// 인스턴스 변수는 객체 생성 후 사용 가능
		card1.kind = "Heart";
		card1.number = 7;
		
		Card card2 = new Card(); // 새로 객체 생성
		card2.kind = "Spade";
		card2.number = 3;
		
		
		// 클래스 변수는 모든 객체가 하나의 저장공간을 공유하므로 항상 공통된 값을 갖는다.
		Card.width = 50;
		card2.height = 90; // 클래스 변수는 객체로 수정해도 전체 같이 바뀜
		
		
		System.out.println("첫번째 카드는 "+ card1.kind + "/" + card1.number +"이며, 크기는 "
							+ card1.width + " X " + card1.height + "입니다.");
		
		System.out.println("두번째 카드는 "+ card2.kind + "/" + card2.number +"이며, 크기는 "
				+ card2.width + " X " + card2.height + "입니다.");
	}

}
