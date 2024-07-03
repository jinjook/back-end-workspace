package com.kh.step5.model;

public class Book {

	/* 캡슐화(Encapsulation)
	 * - 정보은닉 : 외부에서 객체 접근하는데 있어서 정보를 숨기고 객체의 연산을 통해서만 접근이 가능하게 하는 것
	 * - 객체 내 정보손상, 오용을 방지하고, 데이터가 변경되어도 다른 객체에 영향을 주지 않음
	 * - 독립성이 좋고, 하나의 모듈처럼 사용이 가능 
	 * */
	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	
	// alt+shift+s -> Superclass
	public Book() {
	}

	// alt+shift+s -> using Fields
	public Book(String title, int price, double discountRate, String author) {
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
		// int no = 1; -> 이런게 지역변수 (안에서만 사용)
	}
	
	
	// getter, setter : 변수당 한개씩 필요, 나중에 담아내는 역할
	 
	public void setTitle(String title) {// 원하는거 하나만 담아냄. 원칙상 public
		this.title = title; // 타이틀만 넣고싶을 때 
	}
	
	public String getTitle() {// 집어넣는거 아니고, 가지고오는 역할만 해줌 -> 얘만 출력 가능하게 해줌
			return title;
	}
	
	
	// 자동으로 만들어주기 : alt+shift+s -> getter and setter
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", discountRate=" + discountRate + ", author=" + author + "]";
	}





}
