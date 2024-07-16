package com.kh.example.practice2_.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.practice2_.compare.ArtistDescending;
import com.kh.example.practice2_.compare.SongAscending;
import com.kh.example.practice2_.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();
	

	// 1. 마지막 위치에 곡 추가
	public boolean addLastList(Music music) {
		if(!music.getArtist().equals("") && !music.getSong().equals("")) {
			return list.add(music);
		} 
		return false;
	}
	
	// 2. 첫 위치에 곡 추가
	public boolean addFirstList(Music music) {
		if(!music.getArtist().equals("") && !music.getSong().equals("")) {
			 list.add(0, music);
			 return true;
		} 
		return false;
	}
	
	// 3. 전체 곡 목록 출력
	public ArrayList<Music> printAll() {
		return list;
	}
	
	// 4. 특정 곡 검색
	public Music searchMusic(String song) {
		for(Music m : list) {
			// 일부만 검색해도 검색 되도록 : contains 사용
			if(m.getSong().contains(song)) {
				return m;
			}
		}
		return null;
	}
	
	// 5. 특정 곡 삭제
	public Music removeMusic(String song) {
		for(Music m : list) {
			if(m.getSong().equals(song)) {
				return list.remove(list.indexOf(m));
			}
		}
		return null;
	}
	
	// 6. 특정 곡 수정
	public Music updateMusic(String search, Music update) {
		for(Music m : list) {
			if(m.getSong().equals(search)) {
				return list.set(list.indexOf(m), update); // Returns:the element previously at the specified position
			}
		}
		return null;
	}
	
	// 7. 가수명 내림차순 정렬 : 새로 정렬 클래스 추가
	public ArrayList<Music> descArtist() {
		ArrayList<Music> cloneList = (ArrayList<Music>) list.clone(); // 리스트 복
		Collections.sort(cloneList, new ArtistDescending());
		return cloneList;
	}
	
	// 8. 곡명 오름차순 정렬 : 새로 정렬 클래스 추가
	public ArrayList<Music> ascSong() {
		ArrayList<Music> cloneList = (ArrayList<Music>) list.clone();
		Collections.sort(cloneList, new SongAscending());
		return cloneList;
	}
	
	
}
