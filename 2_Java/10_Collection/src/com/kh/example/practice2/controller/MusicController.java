package com.kh.example.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.example.practice2.model.Music;

public class MusicController {
	
	ArrayList<Music> list = new ArrayList<>();
	Music m = new Music();
	
	
	public void AddLast(String music, String name) {
		list.add(new Music(music, name));
	}
	
	public void AddFirst(String music, String name) {
		list.add(0, new Music(music, name));
	}
	
	
	
	public void PrintList() {
		System.out.println("******전체 곡 목록 출력******");
		for(Music m : list) {
			System.out.println(m.getName()+" - "+m.getMusic());
		}
	}
	
	
	public void SearchMusic(String music) {
		for (Music m : list) {
			if(m.getMusic().equals(music)) {
				System.out.println(m.getName()+" - "+m.getMusic()+"을 검색했습니다.");
			}
		}
	}
	
	public void ArrayName() {
		
		System.out.println("******가수 명 내림차순 정렬******");
		List<Music> sub = list.subList(0, list.size());
		Collections.sort(sub);
		Collections.reverse(sub);
		for(Music m : sub) {
			System.out.println(m.getName()+" - "+m.getMusic());
		}
	}
	
	
	int count = 0;
	public void FindMusic(String music) {
		
		for (int i=0; i<list.size(); i++) {
			if(music.equals(m.getMusic())){
				count = i;
			}
		}
		
	}

	public void UpdateMusic(String music, String name) {
		list.set(count, new Music(music, name));
		
	}
	
	
	
	
	
	
}
	