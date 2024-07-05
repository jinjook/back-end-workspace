package com.kh.example.practice1.model;

public class Member {
	// private : 같은 클래스 내에서만 접근 가능
	private String id;
	private String pwd;
	private String name;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	public Member() {};
	// public : : 다른 패키지의 다른 클래스도 접근 가능
	public void changeName(String name) {
		this.name = name;
	}
	public void printName() {
		System.out.println(name); // this.name에서 this. 생략된 것
	}

	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age + ", gender=" + gender + ", phone="
				+ phone + ", email=" + email + "]";
	}

}
