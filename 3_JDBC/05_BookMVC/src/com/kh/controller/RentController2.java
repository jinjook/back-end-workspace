package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;


import com.kh.model.Rent2;
import com.kh.model.dao.RentDAO;

public class RentController2 {
	
	private RentDAO rent = new RentDAO();
	
	// 1. 책 대여
	public boolean rentBook(int memberNo, int bookNo)  {
		
		try {
			// 책은 1권밖에 없음 -> 이미 대여된 책은 대여 불가
			if(!rent.checkRentBook(bookNo)){
				rent.rentBook(memberNo, bookNo);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 2. 내가 대여한 책 조회
	public ArrayList<Rent2> printRentBook(int memberNo){
		try {
			rent.printRentBook(memberNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 3. 대여 취소
	public boolean deleteRent(int num){
		try {
			if(rent.deleteRent(num) == 1) 
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
