package com.kh.example.practice2.controller;

import java.util.ArrayList;
import java.util.Comparator;

import com.kh.example.practice2.compare.AscendingMusic;
import com.kh.example.practice2.compare.DescendingArtist;
import com.kh.example.practice2.model.Music;

public class MusicController {
	
	ArrayList<Music> list = new ArrayList<>();
	Music m = new Music();
	
	public Music FindList(String music) {
		return m;
	}
	
	public void AddLast(String music, String name) {
		list.add(new Music(music, name));
	}
	
	public void AddFirst(String music, String name) {
		list.add(0, new Music(music, name));
	}
		
	public void PrintList() {
		for(Music m : list) {
			System.out.println(m);
		} 
	} 
	
	public Music SearchMusic(String music) {
		for (Music m : list) {
			if(m.getMusic().contains(music)) {
				return m;
			} 
		} return null;
	}
		
	public int FindMusic(String music) {
		for (int i=0; i<list.size(); i++) {
			if(music.equals(list.get(i).getMusic())){
				return i;
			}
		}
		return -1; 
	}

	public Music UpdateMusic(int index, Music music) {
		return list.set(index, music); // Returns:the element previously at the specified position
	}
	
	public Music DeleteMusic(int index) {
		return list.remove(index);
		
	}
			

	public void descArtist() {
		list.stream().sorted(new DescendingArtist())
			.forEach(music -> System.out.println(music));
	}
	

	public void ascMusic() {
		list.stream().sorted(new AscendingMusic())
			.forEach(music -> System.out.println(music));
	}
	
	
}
	