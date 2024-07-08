package com.kh.array.practice3.controller;

import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;

public class BookController {
	
	Member m = new Member();
	Book b = new Book();
	
	public void addMember(String name, int age) {
		m.setName(name);
		m.setAge(age);
	}
	
	public Member info() {
		return m;
	}
	
	public void selectBook(Book b) {
		System.out.println(b);
	}
	

}
