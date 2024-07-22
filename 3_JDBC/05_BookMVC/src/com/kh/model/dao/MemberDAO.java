package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "qwer1234");
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
	
	
	
	// 4. 회원가입
	public void registerMember(String id, String pw, String name) throws SQLException {
		Connection conn = connect();
		String query = "INSERT INTO member(member_id, member_pwd, member_name) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		
		ps.executeUpdate();
		close(ps, conn);
		
	}
	
	// 로그인
	public Member login(String id, String pwd) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member WHERE member_id =? AND member_pwd = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);

		ResultSet rs = ps.executeQuery();
		Member member = null;
		if(rs.next()) {
			member = new Member();
			member.setMemberNo(rs.getInt("member_no"));
			member.setMemberId(id);
			member.setMemberPwd(pwd);
			member.setMemberName(rs.getString("member_name"));
			member.setStatus(rs.getString("status").charAt(0)); // 회원탈퇴 시, 보통 정보삭제가 아니라 status를 Y로 바꿈
		}
		
		close(rs, ps, conn);
		
		return member;
	}
	
	
	//  회원탈퇴
	public int deleteMember(int memberNo) throws SQLException {
		Connection conn = connect();
		String query = "DELETE FROM member WHERE member_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, memberNo);
		
		int result = ps.executeUpdate();
		close(ps, conn);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
