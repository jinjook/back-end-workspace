package com.kh.example.practice2_.compare;

import java.util.Comparator;

import com.kh.example.practice2_.model.Music;

public class ArtistDescending implements Comparator<Music> {

	@Override
	public int compare(Music o1, Music o2) {
		return o2.getArtist().compareTo(o1.getArtist()); // 내림차순
	}

}
