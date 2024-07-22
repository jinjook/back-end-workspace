package com.kh.model;

import java.util.Date;

import com.kh.model.vo.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rent2 {

	private int rentNo;
	private int rentMemNo;
	private int rentBookNo;
	private Date rentDate;
	private Book book;
	
}
