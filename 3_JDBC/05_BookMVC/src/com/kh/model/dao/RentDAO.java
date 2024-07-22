package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Rent2;
import com.kh.model.vo.Book;

public class RentDAO {

	public RentDAO() {
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
	
	

	public void sellBook(int bkNo) throws SQLException {
		Connection conn = connect();
		String query = "DELETE FROM book WHERE bk_no =? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, bkNo);
		
		// 1이 나오는 경우만 삭제되니까 
		ps.executeUpdate();
		close(ps, conn);
		
	}
	
	
	// 대여한 책이 있는지 조회
	public boolean checkRentBook(int no) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM rent WHERE rent_book_no =?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		
		ResultSet rs = ps.executeQuery();
		boolean check = rs.next();
		close(rs, ps, conn);
		
		return check;
	}
	
	// 책 대여
	public void rentBook(int memberNo, int bookNo) throws SQLException {
		Connection conn = connect();
		String query = "INSERT INTO rent(rent_mem_no, rent_book_no) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, memberNo);
		ps.setInt(2, bookNo);
		
		ps.executeUpdate();
		close(ps, conn);
		
		
	}
	
	// 2. 내가 대여한 책 조회
	public ArrayList<Rent2> printRentBook(int memberNo) throws SQLException{
		Connection conn = connect();
		String query = "SELECT * FROM rent JOIN book ON(rent_book_no = bk_no) WHERE rent_mem_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, memberNo);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Rent2> list = new ArrayList<>();
		while(rs.next()) {
			Rent2 rent = new Rent2();
			rent.setRentNo(rs.getInt("rent_no"));
			rent.setRentDate(rs.getDate("rent_date"));
			Book book = new Book();
			book.setTitle(rs.getString("bk_title"));
			book.setAuthor(rs.getString("bk_author"));
			rent.setBook(book);
			list.add(rent);
		}
		close(ps, conn);
		
		return list;
	}
	
	
	// 3. 대여 취소
	public int deleteRent(int num) throws SQLException{
		Connection conn = connect();
		String query = "DELETE FROM rent WHERE rent_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, num);
				
		int result = ps.executeUpdate();
		close(ps, conn);
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
