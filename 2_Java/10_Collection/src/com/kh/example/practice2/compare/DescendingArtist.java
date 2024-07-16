package com.kh.example.practice2.compare;

import java.util.Comparator;

import com.kh.example.practice2.model.Music;

public class DescendingArtist implements Comparator<Music> {

	@Override
	public int compare(Music o1, Music o2) {
		return o2.getName().compareTo(o1.getName());
	}

}
