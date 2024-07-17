package config;

public interface ServerInfo {
	
	/* interface 로 public static final 저장 -> 여기저기 사용 */
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/kh";
	String USER = "root";
	String PASSWORD = "qwer1234";
		

}
