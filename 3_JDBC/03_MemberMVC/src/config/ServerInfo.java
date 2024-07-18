package config;

public interface ServerInfo {
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; // 상수니까 대문자 사용
	String URL = "jdbc:mysql://localhost:3306/member";
	String USER = "root";
	String PASSWORD = "qwer1234";
}
