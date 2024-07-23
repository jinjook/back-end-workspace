package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {
	
	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	public Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		ps.close();
		conn.close();
	}
	
	
	// 회원가입 관련
	public void registerMember(String id, String pwd, String name) throws SQLException {
		Connection conn = connect();
		String query = "INSERT INTO member VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ps.setString(3, name);
		
		ps.executeUpdate();
		close(ps, conn);
	}
	
	// 전체 리스트
	public ArrayList<Member> allMember() throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Member> list = new ArrayList<>();
		
		while(rs.next()) {
			Member m = new Member(rs.getString("id"), rs.getString("password"), rs.getString("name"));
			list.add(m);
			
//			list.add(new Member(rs.getString("id"), rs.getString("password"), rs.getString("name"))); 도 가능
		}
		close(rs, ps, conn);
		return list;
	}
	
	
	// 회원 조회
	public Member searchMember(String id) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		Member m = null;
		
		// rs.next() : rs에 값이 그냥 담기는게 아니라,,꼭 rs.next로 다음 데이터 확인 필요
		// 한개만 호출하면 되니까 if 사용. rs.next가 있을 때 - 조건
		if(rs.next()) {
			m = new Member(id, rs.getString("password"), rs.getString("name"));
		}

		close(rs, ps, conn);
		
		return m;
	}
	
	
	
}
