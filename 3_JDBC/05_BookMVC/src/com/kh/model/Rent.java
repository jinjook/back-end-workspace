package com.kh.model;

import java.util.Date;

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
	private Date rentDate;
	private Date enrollDate;
	
}
