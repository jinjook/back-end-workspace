package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.kh.model.vo.Member;

@Repository
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
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException{
		ps.close();
		conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		rs.close();
		ps.close();
		conn.close();
	}
	
	/* # DAO 개발할 때 중요한 건
	 * - 매개변수(파라미터) 뭘 가지고 와야하는지
	 * - 리턴타입 결과 출력이 어떤게 필요한지
	 */
	
	// 회원가입 -> String 으로 따로 받는것보다 Member 전체로 받는게 편함
	public void registerMember(Member m) throws SQLException {
		Connection conn = connect();
		String query = "INSERT INTO member VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, m.getId());
		ps.setString(2, m.getPwd());
		ps.setString(3, m.getName());
		
		ps.executeUpdate();
		
		close(ps, conn);
	}
	
	// 로그인
	public Member loginMember(String id, String pwd) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member WHERE id =? AND password=? ";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, pwd);
		
		ResultSet rs = ps.executeQuery();
		Member m = null;
		
		if(rs.next()) {
			m = new Member(id, pwd, rs.getString("name"));
		}
		
		close(rs, ps, conn);
		
		return m;
		
	}
	
	// 회원검색
	public Member searchMember(String id) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member WHERE id =? ";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		Member m = null;
		if(rs.next()) {
			m = new Member(id, rs.getString("password"), rs.getString("name"));
		}
		
		close(rs, ps, conn);
		
		return m;
	}
	
	
	// 전체회원검색
	public ArrayList<Member> searchAllMember() throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Member> list = new ArrayList<>();
		
		while(rs.next()) {
			list.add(new Member(rs.getString("id"), rs.getString("password"), rs.getString("name")));
		}
		
		close(rs, ps, conn);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
