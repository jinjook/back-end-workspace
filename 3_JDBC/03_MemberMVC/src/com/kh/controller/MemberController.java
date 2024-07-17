package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Member;


public class MemberController {
	
	public MemberController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
	}
		
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		ps.close();
		conn.close();
	}
	
	public boolean idCheck(String id) throws SQLException {
		
		Connection conn = getConnect();
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Member> list = new ArrayList<>();
		for (Member m : list) {
			if(m.getName().equals(rs.getString("name"))) {
				return false;
			} 
		}  return true;
		
		
	}
	
	public int signUp(String id, String password, String name) {
		try {
		Connection conn = getConnect();
		String query = "INSERT INTO member VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, name);
		
		int result = ps.executeUpdate();
		
		closeAll(ps, conn);
		
		/*boolean check = idCheck(id);
		if(check == true) {
			return result;
		} else {
		return -1;
		}*/
		
		return result;
		} catch (Exception e) {
			return -1;
		}

		// 회원가입 기능 구현! 
		// -> 아이디가 기존에 있는지 체크 여부!
		// -> member 테이블에 데이터 추가! 

	}
	
	public String login(String id, String password) throws SQLException {
		
		Connection conn = getConnect();
		String query = "SELECT * FROM member WHERE id = ? AND password = ? ";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		String name = null;
		
		if(rs.next()) {
			name = rs.getString("name");
			return name;
		}
		
		closeAll(rs, ps, conn);
		
		return name;
		
		// 로그인 기능 구현! 
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!
		
	}
	
	public int changePassword(String id, String password, String newPassword) throws SQLException {
		
		Connection conn = getConnect();
		String query = "UPDATE member SET password = ? WHERE id =? ";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, newPassword);
		ps.setString(2, id);
		
		int result = 0;
		
		String name = login(id, password);
		if(name != null) {
			result = ps.executeUpdate();
		}
		
		closeAll(ps, conn);
		
		return result;

		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경

	}
	
	public void changeName(String id, String newName) throws SQLException {
		Connection conn = getConnect();
		String query = "UPDATE member SET name = ? WHERE id =?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, newName);
		ps.setString(2, id);
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
		
		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 
		
	}
	
}









