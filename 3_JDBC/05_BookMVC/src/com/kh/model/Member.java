package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	private int memNo;
	private String id;
	private String pw;
	private String name;
	
}
