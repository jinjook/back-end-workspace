package com.kh.example.practice2.model;

public class Music implements Comparable<Music> {

	private String music;
	private String name;
	
	
	public Music() {
	}
	
	public Music(String music, String name) {
		this.music = music;
		this.name = name;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Music [music=" + music + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Music o) {
		return this.name.compareTo(o.name);
	}
	
	
}