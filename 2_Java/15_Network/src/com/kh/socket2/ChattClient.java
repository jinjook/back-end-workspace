package com.kh.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/* 키보드로 입력받은 데이터를 읽어서 서버로 보낸다
 * + 다시 서버가 보낸 메세지를 받아서 클라이언트 자신의 콘솔창에 출력한다
 * 
 * 클라이언트측 로직
 * 1. 소켓 생성
 * 2. 스트림
 * */

public class ChattClient {
	
	public static void main(String[] args) {
		
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			Socket s = new Socket(ip, 6000);
			
			// 키보드로 입력받은 데이터를 '읽어서'
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// 서버에게 '보내는' 역할
			PrintWriter pw = new PrintWriter (s.getOutputStream(), true);
						
			// 다시 서버가 보낸 메세지를 받아서 클라이언트 자신의 콘솔창에 출력한다
			BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			while(true) {
				String line = br.readLine();// 내가 입력한것
				pw.println(line); // 서버로 보내기
				
				String serverMsg = br2.readLine();// 서버에서 받은 것
				System.out.println("내가 보낸 메세지 : " + serverMsg); // 출력
			}
			
		} catch (Exception e) {
			System.out.println("서버 연결에 실패했습니다.");
		}
		
	}

}
