package com.kh.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.api.model.vo.BigGroup;
import com.kh.api.model.vo.BigSchedule;
import com.kh.api.model.vo.SmallGroup;
import com.kh.api.model.vo.User;
import com.kh.api.service.GroupService;
import com.kh.api.model.vo.SmallSchedule;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class GroupController {
	@Autowired
	private GroupService service;
	
	@ResponseBody
	@PostMapping("/addGroup")
	public boolean addGroup(BigGroup bigGroup, String groupName, HttpServletRequest request) {
			System.out.println(groupName);
			service.addGroup(bigGroup);
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			String id =user.getId();
			
			BigGroup bg = service.searchBgCode(groupName);
			int bgGroupCode = bg.getBgGroupCode();
			
			SmallGroup smGroup = new SmallGroup(new User(id), new BigGroup(bgGroupCode));
			service.addSmGroup(smGroup);
			
			return true;
	}
	
	@ResponseBody
	@PostMapping("/userGroup")
	public List<SmallGroup> userGroup(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String id =user.getId();
		List<SmallGroup> list = service.allInfoGroup(id);
		model.addAttribute("list", list);
		return list;
	}
	
	@ResponseBody
	@PostMapping("/scheduleAdd")
	public String schduleAdd(HttpServletRequest request, String groupName, BigSchedule bs) {
		System.out.println(groupName);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String id = user.getId();
		BigGroup bg = service.searchBgCode(groupName);
		BigSchedule bgs = new BigSchedule(bg, new User(id));
		service.scheduleAdd(bgs);
		
		return "redirect:/main?groupName="+ groupName;
	}
	
	@ResponseBody
	@PostMapping("/scheduleAdd2")
	public void scheduleAdd2(String groupName, SmallSchedule sms) {
		SmallSchedule small = sms;
		BigGroup bg = service.searchBgCode(groupName);
		System.out.println(bg);
		int num = bg.getBgGroupCode();
		System.out.println(num);
		BigSchedule bgs = service.searchBsCode(num);
		int a = bgs.getBsCode();
		System.out.println(a);
	}
	
	
}
