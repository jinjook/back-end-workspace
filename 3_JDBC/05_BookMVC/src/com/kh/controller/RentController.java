package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Member;
import com.kh.model.Rent;
import com.kh.model.dao.BookDAO;
import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Book;

public class RentController {
	
	private BookDAO bookD = new BookDAO();
	private RentDAO rentD = new RentDAO();

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
	
	
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
		try {
			return bookD.printBookAll();
		} catch (SQLException e) {
			return null;
		}
	}
	
	// 2. 책 등록
	public boolean registerBook(String title, String author)  {
		try {
			if(!bookD.bkCheck(title, author)) {
				bookD.registerBook(title, author);
				return true;
			}
		} catch (SQLException e) {
			
		}
		return false;
	}
	
	
	// 3. 책 삭제
	public boolean sellBook(int bkNo) {
		
		try {
			// 빌려있는 책 삭제 못하게
			if(rentD.checkRentBook(bkNo)) {
				return false;
			}
			// 아닐때 책 삭제
			// 없는 번호 삭제하려고 하면 실패가 떠야함
			// -> 기존 책들 중에 해당 bkNo가 있는 경우만 삭제
			for(Book b : bookD.printBookAll()) {
				if(b.getBkNo()==bkNo) {
					bookD.sellBook(bkNo);	
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/* MemberController
	public boolean idCheck(String id) throws SQLException {
		Connection conn = connect();
		String query = "SELECT member_id FROM member WHERE member_id =? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		String checkId = null; 
		
		if(rs.next()) checkId = rs.getString("member_id");
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
			m = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_pwd"), rs.getString("member_name"));
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
	
	
	public boolean bkNoCheck(int bkNo) throws SQLException {
		// 같은 책을 여러 사용자가 대여할 수 없음 -> 책 1권
		// 대여 후 다른 사람은 대여 못하게
		Connection conn = connect();
		String query = "SELECT rent_book_no FROM rent WHERE rent_book_no =? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, bkNo);
		
		ResultSet rs = ps.executeQuery();
		String checkBk = null; 
		
		if(rs.next()) checkBk = rs.getString("rent_book_no"); // 컬럼명!!!!!!!!!
		close(rs, ps, conn);
		 
		if(checkBk != null) return true;
				
		return false;
	}

		
	
	
		
	public boolean rentBook(Member m, int bkNo) throws SQLException {
		
		if(!bkNoCheck(bkNo)) {
		Connection conn = connect();
		String query = "INSERT INTO rent (rent_mem_no, rent_book_no) VALUES(?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, m.getMemNo());
		ps.setInt(2, bkNo);
		
		ps.executeUpdate();
		close(ps, conn);
		
		return true;
		}
		return false;
	}
	
	
	// 대여 여부 확인
	public boolean rentCheck(Member m) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM rent WHERE rent_mem_no =? ";
		PreparedStatement ps = conn.prepareStatement(query);
//		System.out.println(m.getMemNo());
		ps.setInt(1, m.getMemNo());
		
		ResultSet rs = ps.executeQuery();
		String checkRent = null; 

		
		
		if(rs.next()) checkRent = rs.getString("rent_mem_no"); // 컬럼명!!!!!!!!!
		
//		System.out.println("checkRent : " + checkRent);
			
		close(rs, ps, conn);
		
		if(checkRent != null) {
//			System.out.println("!!");
			return true;
		}
		return false;
	}
	
	
	
	public ArrayList<Rent> printRentBook(Member m) throws SQLException {
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
//		System.out.println(!rentCheck(m));
		ArrayList<Rent> list = new ArrayList<>();
		if(!rentCheck(m)) {
			System.out.println("!!!");
			Connection conn = connect();
			String query = "SELECT rent_no, bk_title, bk_author, rent_date, enroll_date	FROM rent JOIN member ON (rent_mem_no = member_no) JOIN book ON (rent_book_no = bk_no) WHERE rent_mem_no =?" ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, m.getMemNo());
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Rent rent = new Rent();
				rent.setRentNo(rs.getInt("rent_no"));
				rent.setBkTitle(rs.getString("bk_title"));
				rent.setBkAuthor(rs.getString("bk_author"));
				rent.setRentDate(rs.getDate("rent_date"));
				rent.setEnrollDate(rs.getDate("enroll_date"));
				list.add(rent);
			}
			close(rs, ps, conn);
			
		} 
		return list;
	}
	
	
	// 3. 대여 취소
		public boolean deleteRent(int rentNo) throws SQLException {
			Connection conn = connect();
			String query = "DELETE FROM rent WHERE rent_no =? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, rentNo);
			
			ps.executeUpdate();
			
			close (ps, conn);
			return true;
		}

		// 4. 회원탈퇴
		public boolean deleteMember(Member m) throws SQLException {
			// 1. 회원탈퇴할 때 대여중인 책 있으면 탈퇴 못하게 막던가
			if(!rentCheck(m)) {
				Connection conn = connect();
				String query = "DELETE FROM member WHERE member_no =?";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setInt(1, m.getMemNo());
				
				ps.executeUpdate();
				
				close(ps, conn);
				return true;
			} 
			return false;
		}
	
	*/
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
