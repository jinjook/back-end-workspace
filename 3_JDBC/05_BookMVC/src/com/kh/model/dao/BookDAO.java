package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Book;
import com.kh.model.vo.Publisher;

/* DAO (Data Access Object)
 * - DB에 접근하는 역할을 하는 객체 (CRUD)
 * - DB로 받는건 전부 DAO에 넣으면 됨
 * */


public class BookDAO {
	
	public BookDAO() {
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
	
	
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException{
		Connection conn = connect();
		String query = "SELECT * FROM book LEFT JOIN publisher ON (bk_pub_no = pub_no)";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Book> list = new ArrayList<>();
		
		while(rs.next()) {
			Book bk = new Book();
			bk.setBkNo(rs.getInt("bk_no"));
			bk.setTitle(rs.getString("bk_title"));
			bk.setAuthor(rs.getString("bk_author"));
			
			Publisher publisher = new Publisher();
			publisher.setPubName(rs.getString("pub_name"));
			bk.setPublisher(publisher);
			
			list.add(bk);
		}
		close(rs, ps, conn);
		return list;
	}
	
	
	// 2-1. 책 확인 여부
	public boolean bkCheck(String title, String author) throws SQLException {
		Connection conn = connect();
		String query = "SELECT bk_title, bk_author FROM book WHERE bk_title=? AND bk_author=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, title);
		ps.setString(2, author);
		
		ResultSet rs = ps.executeQuery();
		
		boolean check = rs.next(); // 있으면 true, 없으면 false
		close(rs, ps, conn);
		
		return check;
	}

	// 2-2. 책 등록
	public void registerBook(String title, String author) throws SQLException {
		Connection conn = connect();
		String query = "INSERT INTO book (bk_title, bk_author) VALUES(?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, title);
		ps.setString(2, author);
		
		ps.executeUpdate();
		close(ps, conn);
	}
	
	
	// 3. 책 삭제
	public boolean sellBook(int bkNo) throws SQLException {
		Connection conn = connect();
		String query = "DELETE FROM book WHERE bk_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, bkNo);
		
		ps.executeUpdate();
		close(ps, conn);

		return false;
	}
	
	
	
	
	
	
	
	
	
	
}
