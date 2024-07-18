package com.kh.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.model.Member_;

import config.ServerInfo;

public class MemberController_ {
	
	Properties p = new Properties();
	
	/* 싱글톤 패턴(Singleton Pattern)
		- 디자인 패턴 중 하나로 클래스가 '최대 한 번만 객체 생성되도록' 하는 패턴
		- 한번만 생성하려면 private 을 붙여야함
		- controller 는 메서드로 호출하는 역할이라서 사용 가능
		
		1. 생성자는 private : 여기저기서 객체 생성하지 못하도록
		private MemberController() { }
		
		2. MemberController_(객체) 를 유일하게 담을 수 있는 static 변수 지정
		private static MemberController instance;
		
		3. 객체를 반환하는 static 메서드
		public static MemberController getInstance() { }
	*/ 
	
	private MemberController_() { // 생성자
		
		try {// 생성자에서는 throw 하지 않음
			
			// File 연결
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			// 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static MemberController_ instance; // 변수 지정
	
	public static MemberController_ getInstance() { 
		if(instance == null) instance = new MemberController_();
		return instance;
	}
	
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps, conn);
	}
	

	
	// -- 기능구축 전 공통 사용 되는 메서드 모두 정리 완료 -- //
	
	// 아이디 중복 체크 메서드 -> try/catch 보다 속도가 조금 더 빠름
	public boolean idCheck(String id) throws SQLException {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("idCheck"));
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		String checkId = null;
		
		if(rs.next()) checkId = rs.getString("id");
		close(rs, ps, conn);
		
		if(checkId != null) return true;
		
		return false;
	}
	
	// 회원가입 기능 구현! 
	public boolean signUp(Member_ m) throws SQLException {
		// -> 아이디가 기존에 있는지 체크 여부!
		if(!idCheck(m.getId())) {
			// -> member 테이블에 데이터 추가! 
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("signUp"));
			
			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());
			
			ps.executeUpdate();
			close (ps,conn);
			
			return true;
		}
		return false;
	}
	
	
	// 로그인 기능 구현!
	public String login(String id, String password) throws SQLException {
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("login"));
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		String name = null;
		
		if(rs.next()) name = rs.getString("name");
		close(rs, ps, conn);
		
		return name;
		
	}
	
	
	// 비밀번호 바꾸기 기능 구현!
	public boolean changePassword(String id, String oldPw, String newPw) throws SQLException {
		
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경 : id가 primary key니까
		if(login(id, oldPw) != null) {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("changePassword"));
			ps.setString(1, newPw);
			ps.setString(2, id);
			
			ps.executeUpdate();
			return true;			
		}
		return false;
	}
	
	
	// 이름 바꾸기 기능 구현!
	public void changeName(String id, String newName) throws SQLException {
		// -> member 테이블에서 id로 새로운 이름으로 변경 : id가 primary key니까
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("changeName"));
		
		ps.setString(1, newName);
		ps.setString(2, id);
		
		ps.executeUpdate();
		close(ps, conn);
	}
	
}









