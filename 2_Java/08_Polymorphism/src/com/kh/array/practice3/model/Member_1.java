package com.kh.array.practice3.model;

import java.util.Arrays;

public class Member_1 {

	private String name;
	private int age;
	private int coupon;
	private Book_1[] bookList = new Book_1[2];
	// ArrayList 사용 시 private ArrayList<Book> bookList = new ArrayList<>();로 변경

	public Member_1 () {
	}
	public Member_1 (String name, int age, int coupon, Book_1[] bookList) {
		this.name = name;
		this.age = age;
		this.coupon = coupon;
		this.bookList = bookList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public Book_1[] getBookList() {
		return bookList;
	}
	public void setBookList(Book_1[] bookList) {
		this.bookList = bookList;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}

}