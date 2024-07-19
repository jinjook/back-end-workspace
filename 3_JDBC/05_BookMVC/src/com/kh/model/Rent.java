package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rent {
	
	private int rentNo;
	private String bkTitle;
	private String bkAuthor;
	private String rentDate;
	private String enrollDate;
	
}
