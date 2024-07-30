package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.model.vo.Member;
import com.kh.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	@Autowired // Service 와 연결
	private MemberService service;
	
	@GetMapping("/")
	public String index() {
	 return "index";	
	}

	@GetMapping("register") // 페이지 로딩
	public void register() {}
	// String return "register"와 동일
	
	@PostMapping("register")	
	public String register(Member vo) {
		try {
			service.register(vo);
		} catch (SQLException e) {
			
		}
		return "redirect:/";
	}
	
	
	
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("login")
	public String login(Member vo, HttpServletRequest request) {
		
		try {
			Member m = service.login(vo);
			HttpSession session = request.getSession();
			session.setAttribute("login", m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	
	
	@GetMapping("search")
	public void search() {}
	
	@GetMapping("find")
	public String find(@RequestParam("id") String id, Model model) {
		
		try {
			Member m = service.search(id);
			
			if(m != null) {
				model.addAttribute("search", m);
				return "search_ok";
			} 
		} catch (SQLException e) {
			}
		return "redirect:/fail";
	}
	
	@GetMapping("fail")
	public String faile() {
		return "search_fail";
	}
	
	@GetMapping("allMember")
	public String allMember(Model model) {
		
	
		try {
			List<Member> list = service.allMember();
			model.addAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return "allMember";
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("login");
		
		if(m != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
}
