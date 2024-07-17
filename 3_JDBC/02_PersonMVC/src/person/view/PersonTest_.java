package person.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import person.controller.PersonController_;
import person.model.Person;


public class PersonTest_ {
	
	PersonController_ pc = new PersonController_();

	
	public static void main(String[] args) {
		PersonTest_ pt = new PersonTest_();
		
		try {
//		pt.searchAllPerson();
//		pt.addPerson("박세영", 5, "서울");
//		pt.addPerson("배영운", 6, "경기");
//		pt.addPerson("이동호", 7, "서울");
//		pt.updatePerson(new Person(1, "김진주", 8, "제주"));
//		pt.removePerson(4);
		pt.searchPerson(7);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	// person 테이블에 데이터 추가 - INSERT
	public void addPerson(String name, int age, String addr) throws SQLException {
		int result = pc.addPerson(name, age, addr);
		if(result == 1) 
			System.out.println(name+"님, 회원가입 완료:)");
		
	}
	
	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson(Person person) throws SQLException {
		String name = pc.updatePerson(person);
		if(name!=null) {
			System.out.println(name + "님, 정보 수정 완료");
		}
	}
	
	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson(int id) throws SQLException {
		String name = pc.removePerson(id);
		System.out.println(name + "님, 회원탈퇴 완료");
	}
	
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() throws SQLException {
		
		ArrayList<Person> list = pc.searchAllPerson();
		for(Person p : list) {
			System.out.println(p);
		}
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson(int id) throws SQLException {
		Person p = pc.searchPerson(id);
		System.out.println(p);
	}
	
}
