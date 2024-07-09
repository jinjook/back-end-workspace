package com.kh.array.practice3.model;

import java.util.Arrays;

public class Member extends Book{

	Book[] bookList = new Book[2];
	
	private String name;
	private int age;
	public int ccoupon;
	
	
	public Member() {
	}
	public Member(String title, boolean coupon, int accessAge, String name, int age, int ccoupon) {
		super(title, coupon, accessAge);
		this.name = name;
		this.age = age;
		this.ccoupon = ccoupon;
	}
	public Member(String name, int age, int ccoupon) {
		this.name = name;
		this.age = age;
		this.ccoupon = ccoupon;
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
	public int getCcoupon() {
		return ccoupon;
	}
	public void setCcoupon(int ccoupon) {
		this.ccoupon = ccoupon;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", ccoupon=" + ccoupon + ", bookList = " + Arrays.toString(bookList) + "]";
		
	}
	
	
	
	
}
