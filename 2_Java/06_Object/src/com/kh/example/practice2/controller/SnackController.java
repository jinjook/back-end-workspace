package com.kh.example.practice2.controller;

import com.kh.example.practice2.model.Snack;

public class SnackController {
	
	private Snack s = new Snack();
	// 해당하는 controller 내에서만 쓰는 변수로 지정 -> private
	// saveData에서 담고 confirmData에서 반환해야하는 상황
	// method 밖에다 넣어야 saveData, confirmData에 모두 쓸 수 있음
	
	
	// 데이터들을 서버한테 요청, 서버한테 전달할때는 controller 로
	// 매개변수 = parameter
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
	// 데이터를 setter 이용해 저장하고 "저장 완료되었습니다" 결과를 반환
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		return "저장 완료되었습니다.";
	}
	
	
	public String confirmData() {
		// 저장된 데이터를 반환하는 method
		return  s.getKind()+"("+s.getName()+" - "+s.getFlavor()+") "+s.getNumOf()+"개 "+s.getPrice()+" 원";
	}

}

	
	
