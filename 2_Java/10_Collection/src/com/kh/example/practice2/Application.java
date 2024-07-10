package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.MusicController;

public class Application {

	Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();
	
	
	public static void main(String[] args) {
		Application a = new Application();
		a.MainMenu();
	}

	public void MainMenu() {
		
		boolean check = true;
		while (check) {

			System.out.println("=====메인 메뉴=====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 가수 명 내림차순 정렬");
			System.out.println("8. 곡 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			try {
				int select = Integer.parseInt(sc.nextLine());

				switch (select) {
				case 1:
					AddLast();
					break;
				case 2:
					AddFirst();
					break;
				case 3:
					mc.PrintList();
					break;
				case 4:
					SearchMusic();
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					mc.ArrayName();
					break;
				case 8:
					break;
				case 9:
					System.out.println("종료");
					check = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("잘못 입력했습니다.");
			}
		}

	}
	
	public void AddLast() {
		
		System.out.println("******마지막 위치에 곡 추가*****");
		System.out.print("곡 명 : ");
		String music = sc.nextLine();
		System.out.print("가수 명 : ");
		String name = sc.nextLine();
		
		mc.AddLast(music, name);
		System.out.println("추가 성공");
	}
	
	
	public void AddFirst() {
		
		System.out.println("******첫 위치에 곡 추가*****");
		System.out.print("곡 명 : ");
		String music = sc.nextLine();
		System.out.print("가수 명 : ");
		String name = sc.nextLine();
		
		mc.AddFirst(music, name);
		System.out.println("추가 성공");
	}
	
	
	
	public void SearchMusic() {
		
		System.out.println("******특정 곡 검색******");
		System.out.print("검색할 곡 명 : ");
		String music = sc.nextLine();
		
		mc.SearchMusic(music);
	}
	
	public void UpdateMusic() {
		System.out.println("******특정 곡 수정******");
		System.out.print("검색할 곡 명 : ");
		String music = sc.nextLine();
		mc.FindMusic(music);
	
		System.out.print("수정할 곡 명 : ");
		music = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String name = sc.nextLine();
		mc.UpdateMusic(music, name);
		
	}
	
	
	
	
	
	
	
	
	
}
