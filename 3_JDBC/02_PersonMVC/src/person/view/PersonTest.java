package person.view;

import java.sql.SQLException;
import java.util.Scanner;

import person.controller.PersonController;


public class PersonTest {
	
	PersonController pc = new PersonController();

	
	public static void main(String[] args) {
		PersonTest pt = new PersonTest();
		
		
		pt.searchAllPerson();
		
//		pt.addPerson("박세영", 5, "서울");
		
		
		
		
		/*System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("주소 : ");
		String addr = sc.nextLine();
		System.out.print("아이디 : ");
		int id = Integer.parseInt(sc.nextLine());
		 */
		
	}

	// person 테이블에 데이터 추가 - INSERT
	public void addPerson(String name, int age, String addr) {
		int result = pc.addPerson(name, age, addr);
		if(result != -1) 
			System.out.println(name+"님, 회원가입 완료:)");
		else System.out.println("회원 가입 실패");
	}
	
	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson(int id, String name, int age, String addr) {
		if(pc.updatePerson(id, name, age, addr) != -1)
		System.out.println(name+"님, 정보수정 완료:)");
		else System.out.println("정보 수정 실패");
	}
	
	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson(int id) {
		if(pc.removePerson(id) != -1)
			System.out.println("회원탈퇴 완료");
		else System.out.println("회원탈퇴 실패");
	}
	
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() {
		pc.searchAllPerson();
		
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson(int id) {
		pc.searchPerson(id);
	}
	
}
