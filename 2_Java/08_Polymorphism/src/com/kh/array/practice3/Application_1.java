package com.kh.array.practice3;

import java.util.Scanner;

import com.kh.array.practice3.controller.BookController1;
import com.kh.array.practice3.model.Book_1;

public class Application_1 {
	/* 풀이 */
	Scanner sc = new Scanner(System.in);
	BookController1 bc = new BookController1(); 
	Book_1[] books = {new Book_1("밥을 지어요", true, 0), 
				new Book_1("오늘은 아무래도 덮밥", false, 0), 
				new Book_1("원피스 108", false, 15), 
				new Book_1("귀멸의 칼날 23", false, 19)};
	
	
	/* ArrayList로 변경 시,
	 * 
	 * ArrayList<Book> books = new ArrayList<>();
	 * { 반드시 중괄호로 묶어줘야 실행 가능
	 * 	books.add(new Book_1("밥을 지어요", true, 0));
	 *  books.add(new Book_1("오늘은 아무래도 덮밥", false, 0));
	 *  books.add(new Book_1("원피스 108", false, 15));
	 *  books.add(new Book_1("귀멸의 칼날 23", false, 19));
	 *  }
	 * */
	
	

	public static void main(String[] args) {
		Application_1 app = new Application_1();
		app.menu();
	}

	public void menu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		bc.addMemeber(name, age);

		boolean close = true;
		while (close) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			
			
		switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				System.out.println(bc.myPage());
				break;
			case 2:
				rent();
				break;
			case 3:
				close = false;
				break;
		}}
	}

	public void rent() {
		for (int i = 0; i < books.length; i++) { // ArrayList일때는 books.length -> books.size() 변경
			System.out.println((i + 1) + "번 도서 : " + books[i]); // ArrayList일때는 books[i] -> books.get[i] 변경
		}
		System.out.print("대여할 도서 번호 선택 : ");
		int select = Integer.parseInt(sc.nextLine());
		System.out.println(bc.rentBook(books[select-1])); // ArrayList일때는 books[select-1]) -> books.get(select-1) 변경
	}
	
	
	
	
}