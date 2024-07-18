package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TXCommitTest {

	public static void main(String[] args) {
	
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
			
			// 3. PreparedStatement + 쿼리문
			String query1 = "INSERT INTO member VALUES (?, ?, ?)";
			String query2 = "SELECT * FROM member WHERE id =?";
			
			// transaction 시작!
			conn.setAutoCommit(false); // auto commit 꺼버리기 -  commit : 모든 작업들을 정상적으로 처리하겠다고 확정하는 구문
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, "test2");
			ps1.setString(2, "pass2");
			ps1.setString(3, "테스트2");
			
			ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setString(1, "test5");
			
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next()) {
				// 회원이 존재
				conn.rollback();
				System.out.println("회원이 존재하여 회원 추가 불가");
			} else {
				// 회원이 존재하지 않음
				conn.commit();
				System.out.println("회원 추가 완료");
			}
			
			// transaction 끝! -> 다시 원래대로 돌려놓기
			conn.setAutoCommit(true);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
