package com.kh.array.practice3.controller;

import java.util.Arrays;

import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;

public class BookController {
	
	Member m = new Member();
	Book[] bookList = new Book[2];
	public int count = 0;
	
	public void addMember(String name, int age) {
		m.setName(name);
		m.setAge(age);
	}
		
	public void selectBook(Book b) {
		bookList[count++] = new Book (b.getTitle(), b.isCoupon(), b.getAccessAge());
		if(b.isCoupon() == true) {
			m.ccoupon++;
		}
		
	}
	
	
	public String myPage() {
		return "Member [name=" + m.getName() + ", age=" + m.getAge() + ", coupon=" + m.getCcoupon() + ", bookList = " + Arrays.toString(bookList) + "]";
	}
	

}
