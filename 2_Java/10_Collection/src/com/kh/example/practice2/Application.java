package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.MusicController;
import com.kh.example.practice2.model.Music;

public class Application {

	Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();
	
	/* 문제점..
	 *  곡 명 오름차순 정렬  : 각 클래스 생성
	 *  검색 : small 검색시에도 small girl 이 나올 수 있게 : contains 사용
	 *  수정 : 수정 후 멘트 '수정전 이름 - 수정전 곡의 값이 변경 되었습니다.' : Music 으로 리턴
	 * */
	
	
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

				switch(select) {
				case 1:
					AddLast();
					break;
				case 2:
					AddFirst();
					break;
				case 3:
					System.out.println("******전체 곡 목록 출력******");
					mc.PrintList();
					break;
				case 4:
					SearchMusic();
					break;
				case 5:
					DeleteMusic();
					break;
				case 6:
					UpdateMusic();
					break;
				case 7:
					System.out.println("******가수 명 내림차순 정렬******");
					mc.descArtist();
					break;
				case 8:
					System.out.println("******곡 명 오름차순 정렬******");
					mc.ascMusic();
					break;
				case 9:
					System.out.println("종료");
					check = false;
					break;
				default : 
					System.out.println("없는 번호입니다");
				}
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
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
		
		Music m = mc.SearchMusic(music);
		
		if(m != null)System.out.println(m + "을 검색했습니다.");
		else System.out.println("검색할 곡을 찾지 못했습니다.");
	}
	
	public void UpdateMusic() {
		System.out.println("******특정 곡 수정******");
		System.out.print("검색할 곡 명 : ");
		String search = sc.nextLine();
		int index = mc.FindMusic(search);
		if(index == -1) {
			System.out.println("수정할 곡을 찾지 못했습니다.");
		} else {
			System.out.print("수정할 곡 명 : ");
			String music = sc.nextLine();
			System.out.print("수정할 가수 명 : ");
			String name = sc.nextLine();
			
			Music m = mc.UpdateMusic(index, new Music(music, name));
			System.out.println(m + "의 값이 변경 되었습니다.");
		}
	}
	
	public void DeleteMusic() {
		System.out.println("******특정 곡 삭제******");
		System.out.print("삭제할 곡 명 : ");
		String music = sc.nextLine();
		int index = mc.FindMusic(music);
		if(index == -1) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			System.out.println(mc.DeleteMusic(index)+"을 삭제했습니다.");
//			System.out.println(m.getName()+ " - " + m.getMusic()+"을 삭제했습니다.");
		}
	}
	
	
	
	
	
	
	
}
