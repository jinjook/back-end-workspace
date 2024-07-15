package com.kh.array.practice3.controller;

import com.kh.array.practice3.model.Book_1;
import com.kh.array.practice3.model.Member_1;

public class BookController1 {

	private Member_1 member = new Member_1();
	int count = 0;	
	
	// 내 정보 추가
	public void addMemeber(String name, int age) {
		member.setName(name);
		member.setAge(age);
	}
	
	// 마이페이지
	public Member_1 myPage() {
		return member;
	}
	
	// 책 대여
	public String rentBook(Book_1 book) {
		Book_1[] bookList = member.getBookList();
		
		// 이미 대여한 책은 대여 불가능하게 만들어야 하는 경우
		for (Book_1 value : bookList) {
			if (value != null && value.equals(book)) {
				return "이미 대여한 책입니다.";
			}
		}
		if(count < 2) {
			if(member.getAge() < book.getAccessAge()) {
				return "나이 제한으로 대여 불가능입니다.";
			}
			bookList[count++] = book;
			// 쿠폰을 가지고 있는 경우
			if (book.isCoupon()) {
				member.setCoupon(member.getCoupon() + 1);
			}
			return "성공적으로 대여되었습니다.";
		}
		return "더 이상 대여할 수 없습니다.";
	}
	
	
	
	
	
	
	
}
