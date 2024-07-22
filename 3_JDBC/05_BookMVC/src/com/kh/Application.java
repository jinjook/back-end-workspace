package com.kh;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.controller.RentController;
import com.kh.controller.RentController2;
import com.kh.model.vo.Member;
import com.kh.model.Rent2;
import com.kh.model.vo.Book;

/* Schema : sample
 * Table : member, book, publisher, rent
 * */


public class Application {

	private Scanner sc = new Scanner(System.in);
	private RentController rc = new RentController();
	private MemberController mc = new MemberController();
	private RentController2 rc2 = new RentController2();
	Member member =  new Member();

	public static void main(String[] args) {

		Application app = new Application();
		try {
		app.mainMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void mainMenu() throws SQLException {
		
		
			System.out.println("===== 도서 관리 프로그램 =====");

			boolean check = true;
			while (check) {
				System.out.println("1. 전체 책 조회");
				System.out.println("2. 책 등록");
				System.out.println("3. 책 삭제");
				System.out.println("4. 회원가입");
				System.out.println("5. 로그인");
				System.out.println("9. 종료");
				System.out.print("메뉴 번호 입력 : ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					printBookAll();
					break;
				case 2:
					registerBook();
					break;
				case 3:
					sellBook();
					break;
				case 4:
					registerMember();
					break;
				case 5:
					login();
					break;
				case 9:
					check = false;
					System.out.println("프로그램 종료");
					break;
				default : 
					System.out.println("없는 번호입니다.");
				}
			}
	}

	// 1. 전체 책 조회
	public void printBookAll() {
		
		// 반복문을 이용해서 책 리스트 출력
		ArrayList<Book> list = rc.printBookAll();
		for(Book b : list) {
//			String pubName = b.getPublisher().getPubName();
			System.out.println("책번호 : " +b.getBkNo()+ ", 책 제목 : " + b.getTitle() + ", 저자 : "+b.getAuthor() 
					+ ", /출판사 : "+b.getPublisher()); 
		}
	}

	
	// 2. 책 등록
	public void registerBook() {
		// 책 제목, 책 저자를 사용자한테 입력 받아
		System.out.print("책 제목 : ");
		String title = sc.nextLine();
		System.out.print("책 저자 : ");
		String author = sc.nextLine();
		// 기존 제목, 저자 있으면 등록 안되게
		if (rc.registerBook(title, author)) {
			// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
			System.out.println("성공적으로 책을 등록했습니다.");
		}else {
			// 실패하면 "책을 등록하는데 실패했습니다." 출력
			System.out.println("책을 등록하는데 실패했습니다.");
		}
	}

	// 3. 책 삭제
	public void sellBook() {
		// printBookAll로 전체 책 조회를 한 후
		printBookAll();
		// 삭제할 책 번호 선택을 사용자한테 입력 받아
		System.out.print("삭제할 책 번호 : ");
		int bkNo = Integer.parseInt(sc.nextLine());
		// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
		if(rc.sellBook(bkNo)) System.out.println("성공적으로 책을 삭제했습니다.");
		// 실패하면 "책을 삭제하는데 실패했습니다." 출력
		else System.out.println("책을 삭제하는데 실패했습니다.");
	}

	// 4. 회원가입
	public void registerMember() {
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
		if(mc.registerMember(id, pw, name)) 
			System.out.println("성공적으로 회원가입을 완료하였습니다.");
		
		// 실패하면 "회원가입에 실패했습니다." 출력
		else System.out.println("회원가입에 실패했습니다.");
	}

	// 5. 로그인
	public void login() {
		// 아이디, 비밀번호를 사용자한테 입력 받아 
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		member = mc.login(id, pw);
		if(member != null) {
			// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후 
			String name = member.getMemberName();
			System.out.println(name + "님, 환영합니다!");
			// memberMenu 호출
			memberMenu();
		}
		// 실패하면 "로그인 실패" 출력
		else System.out.println("로그인 실패");
	}

	public void memberMenu() {
		boolean check = true;
		while (check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				break;
			case 5:
				deleteMember();
				check = false;
				break;
			}
		}
	}

	// 1. 책 대여
	public void rentBook()  {
		// 기존 정보 삭제 후 진행
		// printBookAll 메서드 호출하여 전체 책 조회 출력 후
		printBookAll();
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		System.out.print("대여할 책 번호 선택 : ");
		int bkNo = Integer.parseInt(sc.nextLine());
		
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		if(rc2.rentBook(member.getMemberNo(), bkNo)){
			System.out.println("성공적으로 책을 대여했습니다.");
		} else {
			System.out.println("책을 대여하는데 실패했습니다.");
		}
		
	}

	// 2. 내가 대여한 책 조회
	public void printRentBook(){
	// 내가 대여한 책들을 반복문을 이용하여 조회
		for(Rent2 rent : rc2.printRentBook(member.getMemberNo())) {
			
			LocalDate localDate = new Date(rent.getRentDate().getTime()).toLocalDate();
			// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한(+14일) 조회
			System.out.println("대여번호 : " + rent.getRentNo()
								+ "/ 책 제목 : " + rent.getBook().getTitle()
								+ "/ 책 저자 : " + rent.getBook().getAuthor() 
								+ "/ 대여 날짜 : " + rent.getRentDate()
								+ "/ 반납 기한 : " + localDate.plusDays(14)
					);
		}
	/*  ArrayList<Rent> list = rc.printRentBook(member);
		
		if(list.size() == 0) System.out.println("대여 내역이 없습니다.");
		else for(Rent r : list) System.out.println(r);*/
		
	}

	// 3. 대여 취소
	public void deleteRent(){
		// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
		printRentBook();
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		System.out.print("취소할 대여 번호 선택 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
		if(rc2.deleteRent(num)) 
			System.out.println("성공적으로 대여를 취소했습니다.");
		// 실패하면 "대여를 취소하는데 실패했습니다." 출력
		else System.out.println("대여를 취소하는데 실패했습니다.");
	}

	// 4. 회원탈퇴
	public void deleteMember() {
		if(mc.deleteMember(member.getMemberNo()))
			System.out.println();
		
		/*
		ArrayList<Rent> list = rc.printRentBook(member);
		
		// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
		if(rc.deleteMember(member)) 
			System.out.println("회원탈퇴 하였습니다 ㅠㅠ");
		else {
		// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
		System.out.println("회원탈퇴하는데 실패했습니다.");
		memberMenu();
		}*/
	}

}
