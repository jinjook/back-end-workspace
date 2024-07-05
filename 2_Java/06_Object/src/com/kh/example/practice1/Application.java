package com.kh.example.practice1;

import com.kh.example.practice1.model.Member;

public class Application {

	public static void main(String[] args) {
		
		Member member = new Member();
		
		member.changeName("김먼지");
		member.printName();
		
		System.out.println(member);
		
	}

}
