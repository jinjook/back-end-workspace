package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest2 {
	
	// final static으로 고정
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/kh";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";

	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			
			// 2. 데이터베이스 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
			// 3. PreparedStatement - INSERT : 추가 값을 ?로 입력 -> 값이 바뀌는 부분
			String query = "INSERT INTO employee(emp_id, emp_name, emp_no) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, 900); // (몇번째 ?, 어떤숫자)
			ps.setString(2, "김미경");
			ps.setString(3, "111111-1111111");
			
			// 4. 쿼리문 실행
			System.out.println(ps.executeUpdate() + "명 추가"); // ps.executeUpdate() : 몇개 업데이트 됐는지 int로 반환
					
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
