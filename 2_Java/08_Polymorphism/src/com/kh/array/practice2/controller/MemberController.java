package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

public class MemberController {
	
	private Member[] mArr = new Member[3];
	public int count = 0;
	
	

	// 멤버 추가
	// 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우 -> 따로 method 빼기
	public void insertMember(Member m) {
		 mArr[count++] = new Member(m.getId(), m.getName(), m.getPwd(), m.getEmail(), m.getGender(), m.getAge());
		 
//		 System.out.println(Arrays.toString(mArr));
	}
		
	/* 내 오답
	 * public void add(String id, String name, String pwd, String email, char gender, int age) {
		mArr[] = new Member(m.getId(id), m.getName(name), m.getPwd(pwd), m.getEmail(email), m.getGender(gender), m.getAge(age));
	}*/
	
	
	
	//멤버 아이디 검색 (일치여부) boolean -> 수정을 위해 멤버 index를 아이디로 조회할 수 있게 설정 : int로 변경
	public int checkId(String id) {
		for(int i = 0; i < mArr.length; i++) {
			if (mArr[i]!=null && mArr[i].getId().equals(id)) { 
				// 기본 값은 null -> 들어간 id만 확인해야하기 때문에 null이 아닌 경우를 넣어줘야함
				return i;
			} 
		}
		return -1; // 동일 아이디가 없는 경우
	}
	
	
	// 멤버 수정
	public void updateMember(String id, String name, String email, String pwd) {
		// 누구의 정보수정을 받을 것인가 -> 멤버의 index 찾기
		int index = checkId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPwd(pwd);
	}
	
	
	// 멤버 조회
	public Member[] printAll() {
		return mArr; // 출력은 view(화면)단에서, 여기서는 return으로 던지기만
	}
	
	
	
}
