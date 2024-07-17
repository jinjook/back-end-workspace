package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class PersonController {
	
	// 리턴 타입이나 매개변수(파라미터) 자유롭게 변경 가능
	/* 1. 드라이버 로딩
	 * 2. DB 연결
	 * 3. PreparedStatement - 쿼리
	 * 4. 쿼리 실행 
	 * */
	
	
	private PreparedStatement ps;
			
	public void connection(String query) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "qwer1234");
			ps = conn.prepareStatement(query);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
	// person 테이블에 데이터 추가 - INSERT
	public int addPerson(String name, int age, String addr) {
		try {		
			String query = "INSERT INTO person (name, age, addr) VALUES (?, ?, ?) ";
			connection(query);
			
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, addr);
				
			return ps.executeUpdate();
				
		} catch (Exception e) {
			return -1;
		}
			
	}
		
	// person 테이블에 데이터 수정 - UPDATE
	public int updatePerson(int id, String name, int age, String addr) {
		try {
			String query = "UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ? ";
			connection(query);
				
			ps.setInt(4, id);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, addr);
				
			return ps.executeUpdate(); 
				
		} catch (Exception e) {
			return -1;
		}
			
	}
		
	// person 테이블에 데이터 삭제 - DELETE
	public int removePerson(int id) {
		try {
			String query = "DELETE FROM person WHERE id = ? ";
			connection(query);
				
			ps.setInt(1, id);
				
			return ps.executeUpdate(); 
				
		} catch (Exception e) {
			return -1;
		}
	}
		
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() {
		try {
			String query = "SELECT * FROM person";
			connection(query);
				
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
					
				System.out.println(id +" / " + name + " / " + age + " / " + addr);
			}
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
		
	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson(int id) {
		try {				
			String query = "SELECT * FROM person WHERE id = ? ";
			connection(query);
				
			ps.setInt(1, id);
				
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				int id2 = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
					
				if (id == id2) {
				System.out.println(id +" / " + name + " / " + age + " / " + addr);
				break;
					}
			}			
		} catch (Exception e) {
			System.out.println("검색 실패");
		}
			
	}

}
