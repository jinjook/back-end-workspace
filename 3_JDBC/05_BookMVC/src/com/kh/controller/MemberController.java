package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Rent2;
import com.kh.model.dao.MemberDAO;
import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Member;

public class MemberController {

	private MemberDAO member = new MemberDAO();
	private RentDAO rent = new RentDAO();
	
	// 회원가입
	public boolean registerMember(String id, String pw, String name) {
		try {
			member.registerMember(id, pw, name);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	// 로그인
	public Member login(String id, String pwd) {
		try {
			Member m = member.login(id, pwd);
			// status가 Y(탈퇴)인 사람은 제외
			if(m.getStatus() == 'N') return m;
		} catch (SQLException e) {
			return null;
		}
		return null;
	}
	
	//  회원탈퇴
	public boolean deleteMember(int memberNo) {
		try {
			/*
			// 1. 회원 탈퇴시, 대여중인 책 있으면 탈퇴 불가
			ArrayList<Rent2> bookList = rent.printRentBook(memberNo);
			if(bookList.size() > 0) return false;
			
			if(member.deleteMember(memberNo) == 1) return true;
			*/
			
			// 2. 회원탈퇴시 대여중인 책들 모두 기록 삭제 -> DELETE 조건 CASCADE
			if(member.deleteMember(memberNo) == 1) return true;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
		
	
	
	
	
	
	
	
}
