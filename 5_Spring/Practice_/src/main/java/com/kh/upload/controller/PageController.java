package com.kh.upload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;

@Controller
public class PageController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Board> list = service.allList();
		model.addAttribute("list", list);
		return "index";
	}
		
	@GetMapping("/write")
	public String write() {
		return "write";	
	}
	
	@PostMapping("/write")
	public String insertBoard(Board board) {
		service.insertBoard(board);
		return "redirect:/"	;
	}
	
	@GetMapping("/view")
	public String update(int no, Model model) {
		Board bo = service.selectList(no);
		
		model.addAttribute("bo", bo);
		
		return "view";
	}
	
	@PostMapping("/update")
	public String updateContent(Board bo) {
		service.updateContent(bo);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteContent(int no) {
		service.deleteContent(no);
		
		return "redirect:/";
	}
	
}
