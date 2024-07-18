package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Book;
import com.kh.model.Member;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class RentController {

	public RentController() {
		
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
	
	
	
	
	public ArrayList<Book> printBookAll() throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM book";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<>();
		
		while(rs.next()) {
			Book bk = new Book();
			bk.setNo(rs.getInt("bk_no"));
			bk.setTitle(rs.getString("bk_title"));
			bk.setAuthor(rs.getString("bk_author"));
			list.add(bk);
		}
		
		close(rs, ps, conn);
		return list;
	}
	
	
	
	public boolean bkCheck(String title, String author) throws SQLException {
		Connection conn = connect();
		String query = "SELECT bk_title, bk_author FROM book WHERE bk_title=? AND bk_author=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, title);
		ps.setString(2, author);
		
		ResultSet rs = ps.executeQuery();
		
		String checkTitle = null;
		String checkAuthor = null;
		
		if(rs.next()) {
			checkTitle = rs.getString("bk_title");
			checkAuthor = rs.getString("bk_author");
		}
		close(rs, ps, conn);
		
		if(checkTitle != null && checkAuthor != null)
			return true;
				
		return false;
	}
	
	
	
	public boolean registerBook(String title, String author) throws SQLException {
		
		if(!bkCheck(title, author)) {
		Connection conn = connect();
		String query = "INSERT INTO book (bk_title, bk_author) VALUES(?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		
		ps.executeUpdate();
		close(ps, conn);
		
		return true;
		}
		return false;
	}
	
	public boolean sellBook(int bkNo) throws SQLException {
		Connection conn = connect();
		String query = "DELETE FROM book WHERE bk_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, bkNo);
		
		ps.executeUpdate();
		close(ps, conn);
		
		return true;
	}
	
	
	public boolean idCheck(String id) throws SQLException {
		Connection conn = connect();
		String query = "SELECT member_id FROM member WHERE member_id =? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		String checkId = null; 
		
		if(rs.next()) checkId = rs.getString("member_id"); // 컬럼명!!!!!!!!!
		close(rs, ps, conn);
		 
		if(checkId != null) return true;
				
		return false;
	}
	
	
	
	public boolean registerMember(String id, String pw, String name) throws SQLException {
		
		if(!idCheck(id)) {
		Connection conn = connect();
		String query = "INSERT INTO member(member_id, member_pwd, member_name) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);

		ps.executeUpdate();
		close(ps, conn);
		
		return true;
		}
		return false;
	}
	
	
	public Member login(String id, String pw) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM member WHERE member_id =? AND member_pwd =?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pw);
		
		ResultSet rs = ps.executeQuery();
		Member m = null;
		
		if(rs.next()) {
			m = new Member(rs.getString("member_id"), rs.getString("member_pwd"), rs.getString("member_name"));
		}
		
		close(rs, ps, conn);
		
		return m;
	}
	
	public int memNo(Member m) throws SQLException {
		Connection conn = connect();
		String query = "SELECT member_no FROM member WHERE member_id =?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, m.getId());
		
		ResultSet rs = ps.executeQuery();
		int num = 0;
		close(rs, ps, conn);
		
		if(rs.next()) num = rs.getInt("member_no");
		return num;
	}
	
	/* 책번호 있는지 체크
	public boolean bkNoCheck() throws SQLException {
		Connection conn = connect();
		String query = "SELECT member_id FROM member WHERE member_id =? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		String checkId = null; 
		
		if(rs.next()) checkId = rs.getString("member_id"); // 컬럼명!!!!!!!!!
		close(rs, ps, conn);
		 
		if(checkId != null) return true;
				
		return false;
	}*/
	
	
	
	public boolean rentBook(Member m, int bkNo) throws SQLException {
		
		Connection conn = connect();
		String query = "INSERT INTO rent (rent_mem_no, rent_book_no) VALUES(?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		int num = memNo(m);
		ps.setInt(1, num);
		ps.setInt(2, bkNo);
		
		ps.executeUpdate();
		
		close(ps, conn);
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
