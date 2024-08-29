package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	public void register(Member vo) {
//		System.out.println("암호화 전 : " + vo.getPassword());
//		System.out.println("암호화 후 : " + bcpe.encode(vo.getPassword()));
		
		vo.setPassword(bcpe.encode(vo.getPassword())); // 비밀번호를 암호화 된 것으로 셋팅
		vo.setRole("ROLE_ADMIN");
		
		mapper.register(vo);
	}
	
	public Member login(Member vo) {
		System.out.println("사용자가 입력한 정보 : " + vo);
		Member member = mapper.login(vo.getId());
		System.out.println("DB에 있는 사용자 정보 : " + member);
		
		// 조건 (member 가 null 이 아니고 비밀번호가 true 일때)
		if(member != null && bcpe.matches(vo.getPassword(), member.getPassword())) {
			// 암호화된 패스워드 비교
//			System.out.println("비밀번호 일치하는지 체크 : " + bcpe.matches(vo.getPassword(), member.getPassword()));
			return member;
		}
		
		return null;
	}
}
