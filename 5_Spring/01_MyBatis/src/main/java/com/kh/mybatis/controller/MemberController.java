package com.kh.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mybatis.model.dto.SearchDTO;
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
		
		if(vo.getId() == null) vo.setId(m.getId());
//		System.out.println(vo);
		service.update(vo);
		
		if(vo.getName() == null) vo.setName(m.getName());
		session.setAttribute("login", vo);
		
		return "redirect:/";
	}
	
	@GetMapping("/search")
	public String search(SearchDTO dto, Model model) {
		
		model.addAttribute("search", service.search(dto));
		return "index"; // redirect는 allmember가 보여짐
	}
	
	@PostMapping("/delete") // requestparam = list의 경우, 파라미터로 인식시켜주기
	public String delete(@RequestParam(name="idList", required=false) List<String> idList) {
//		System.out.println(idList);
		if(idList!=null) service.delete(idList);
		return "redirect:/"; // 새로고침 방식
	}
	
}
