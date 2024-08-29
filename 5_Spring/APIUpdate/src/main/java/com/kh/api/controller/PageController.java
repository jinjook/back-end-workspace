package com.kh.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.api.model.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("/developer")
	public String developer() {
		return "developer";
	}
	
	@ResponseBody
	@PostMapping("/selectGroup")
	public String selectGroup(HttpServletRequest request, String groupName){
		HttpSession session = request.getSession();
		session.setAttribute("groupName", groupName);
		
		return "main";
	}
	
}
