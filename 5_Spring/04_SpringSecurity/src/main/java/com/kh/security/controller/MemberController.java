package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.security.config.TokenProvider;
import com.kh.security.model.vo.Member;
import com.kh.security.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@PostMapping("/register")
	public String register(Member vo) {
		
		service.register(vo);
		
		return "redirect:/login";
	}
	
	@ResponseBody
	@PostMapping("/login")
	public String login(Member vo) {
		Member member = service.login(vo);
		if(member!=null) {
			//로그인 성공 -> 1. session 에 값 담기 (=서버에 고객 정보 임시 저장) -> 모든 고객 담기는 너무 큼
			//		   -> 2. 토큰 생성해서 부여 (서버는 토큰 생성만, 갖고 있는 건 클라이언트)
			String token = tokenProvider.create(member);
//			System.out.println(token);
			return token;
		}
		return null;
	}
	
	
	
}
