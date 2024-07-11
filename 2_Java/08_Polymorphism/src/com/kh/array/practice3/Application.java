package com.kh.array.practice3;

import java.util.Scanner;

import com.kh.array.practice3.controller.BookController;
import com.kh.array.practice3.model.Book;
import com.kh.array.practice3.model.Member;

public class Application {

	Scanner sc = new Scanner(System.in);
	Member m = new Member();
	Book b = new Book();
	BookController bc = new BookController();
	int ccoupon = 0;
	
	public static void main(String[] args) {
		
		Application app = new Application();
		app.mainMenu();		
		
	}

	
	public void mainMenu() {
		
		try {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			m.setName(name);
			m.setAge(age);
			bc.addMember(name, age);
		} catch (Exception e) {
			System.out.println("잘못 입력했습니다. 다시 입력해주세요");
			mainMenu();
		}
		boolean check = true;
		while (check) {
			System.out.println("===메뉴===");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			try {
				int select = Integer.parseInt(sc.nextLine());

				switch (select) {
				case 1:
					System.out.println(bc.myPage());
					break;
				case 2:
					if (bc.count < 2) {
						selectBook();
					} else {
						System.out.println("더 이상 대여할 수 없습니다.");
					}
					break;
				case 3:
					check = false;
					break;
				default:
					System.out.println("없는 번호입니다");
				}
			} catch (Exception e) {
				System.out.println("잘못 입력했습니다");
			}
		}
		
	}
	
	public void selectBook() {
		
		Book b1 = new Book("밥을 지어요", true, 0);
		Book b2 = new Book("오늘은 아무래도 덮밥", false, 0);
		Book b3 = new Book("원피스 108", false, 15);
		Book b4 = new Book("귀멸의 칼날 23", false, 19);
		

		System.out.println("1번 도서 : "+ b1);
		System.out.println("2번 도서 : "+ b2);
		System.out.println("3번 도서 : "+ b3);
		System.out.println("4번 도서 : "+ b4);
		System.out.print("대여할 도서 번호 선택 : ");
		try {
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				bc.selectBook(b1);
				System.out.println("성공적으로 대여되었습니다.");
				break;
			case 2:
				bc.selectBook(b2);
				System.out.println("성공적으로 대여되었습니다.");
				break;
			case 3:
				if (m.getAge() < b3.getAccessAge()) {
					System.out.println("나이 제한으로 대여 불가능입니다.");
					selectBook();
				} else {
					bc.selectBook(b3);
					System.out.println("성공적으로 대여되었습니다.");
				}
				break;
			case 4:
				if (m.getAge() < b4.getAccessAge()) {
					System.out.println("나이 제한으로 대여 불가능입니다.");
					selectBook();
				} else {
					bc.selectBook(b4);
					System.out.println("성공적으로 대여되었습니다.");
				}
				break;
			default:
				System.out.println("없는 번호입니다");
				selectBook();
			}

		} catch (Exception e) {
			System.out.println("잘못 입력했습니다");
			selectBook();
		}
	}
	
	}
