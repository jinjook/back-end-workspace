package com.kh.step5;

import com.kh.step5.model.Book;

public class Application {
// public/private : 접근 제한 정도
	public static void main(String[] args) {
		Book book = new Book();
		
		
		
		//book1.price 호출이 안됨 -  private이니까 => 이럴때 생성자를 생성해두면 부를 수 있음
		// 대신 순서는 생성자와 동일하게 작성
		/* 생성자 방식으로 값을 담아냄 */
		Book book1 = new Book("THE MONEY BOOK", 22000, 0.1,"토스");
		
		System.out.println(book1);
		
		
		
		
		
		Book book2 = new Book();
		
		/* setter 방식으로 값을 담아내는 방법 */
		book2.setTitle("허송세월");// 타이틀만 넣고싶을 때 
		// private이라서 book2.title = "허송세월"이 불가능 -> 그걸 가능하게 해주는게 set
		System.out.println(book2);
		
		System.out.println(book2.getTitle());
		// title만 출력하고 싶을 때 println(book2.title()); 불가능 -> 가능하게 해주는게 get
		
		book2.setAuthor("김훈");
		book2.setPrice(18000);
		book2.setDiscountRate(0.2);
		
		System.out.println(book2.getAuthor());
		System.out.println(book1.getTitle()); // book1것도 가져올 수 있음
		
		// 허송세월의 원래 가격은 18000원, 할인된 가격은 14400원
		// THE MONEY BOOK의 원래 가격은 22000원, 할인된 가격은 19800원
		
		int discount = (int)(book1.getPrice()*(1-book1.getDiscountRate()));
		System.out.println(book2.getTitle()+"의 원래 가격은 "+book2.getPrice()+"원, 할인된 가격은 "+(int)(book2.getPrice()*(1-book2.getDiscountRate()))+"원");
		System.out.println(book1.getTitle()+"의 원래 가격은 "+book1.getPrice()+"원, 할인된 가격은 "+discount+"원");

	}

}
