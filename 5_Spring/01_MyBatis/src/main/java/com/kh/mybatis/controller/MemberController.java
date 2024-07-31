package com.kh.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	private MemberService service; // 객체생성 자동으로 해줌
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allMember", service.allMember());
		return "index"; // webapp폴더의 /index.jsp로 이동
	}
	
	@GetMapping("/register") // 접속 페이지 
	public String register() {
		return "mypage/register"; // 해당 페이지로 이동 : webapp의 mypage/register.jsp로 이동
	}
	
	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/"; // 다시 요청 : /, 즉 index로 다시 요청
	}
	
	@GetMapping("/login")
	public String login() {
		return "mypage/login";
	}

	@PostMapping("/login")
		public String login(Member vo, HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.setAttribute("login", service.login(vo));
			return "redirect:/";
		}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("login");
		
		if(m != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	@PostMapping("/update")
	public String update(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("login");
		session.setAttribute("vo", vo);
		if(vo.getName()!=null) service.update(vo);
		else service.update(m.getId(), vo.getPassword());
		
		return "redirect:/";
	}
	
	
	
}
