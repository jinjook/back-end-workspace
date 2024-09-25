package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.BoardService;

/*
 * REST (Representational State Transfer)
 * 	: API를 설계하는 아키텍쳐
 * 
 * RESTful : REST 원칙을 준수하는 방식
 *  
 * API(Application Programming Interface) 
 *  : 서로 다른 애플리케이션들이 서로 데이터를 주고받을 수 있게 하는 도구
 * */

@RestController
@RequestMapping("/api/*") // http://localhost:8080/api/
public class BoardController {
	
	private String path = "\\\\192.168.10.51\\upload\\";

	@Autowired
	private BoardService service;
	
	
	
	// 공통 부분 method로 따로 빼둠
	public void fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		// 중복방지를 위한 UUID 적용 (파일 이름이 같을 때)
		UUID uuid = UUID.randomUUID();
//				System.out.println(uuid.toString());
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		
		File copyFile = new File(path + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장됨
	}
	
	
	public String fileName(MultipartFile file) throws IllegalStateException, IOException {
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		
		File copyFile = new File(path + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장됨
		
		return fileName;
	}
	
	// CRUD : Create - Post, Read - Get, Update - Put, Delete - Delete
	
	// Create - Post 방식
	@PostMapping("/board")
	public ResponseEntity insert(Board vo) throws IllegalStateException, IOException {
		// 1. 파일 업로드 처리 -> fileName가져오기
		String url = fileName(vo.getFile());
		vo.setUrl(url);
		
		// 2. 해당 파일 URL과 함께 title, content DB에 저장
		service.insert(vo);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	
	}
	
	// Read - Get : 전체 목록 보기
	@GetMapping("/board")
	public ResponseEntity list(Paging paging) {
		
		// 2024-08-19T09:29:52 시간 유형 변경 -> formatDate 추가
		List<Board> list = service.allList(paging);
		
		for(Board b : list) {
			LocalDateTime date = b.getDate();
			Date formatDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
			b.setFormatDate(formatDate);
		}
		
		//model.addAttribute("list", list);
		//model.addAttribute("paging", new Paging(paging.getPage(), service.total()));
		
		return ResponseEntity.status(HttpStatus.OK).body(new BoardDTO(list, new Paging(paging.getPage(), service.total())));
	}
	
	// Read - Get : 1개 가져오기
	@GetMapping("/board/{no}")
	public ResponseEntity view(@PathVariable int no) { 
		Board board = service.detail(no);
		if(board!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(board);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}	
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("upload!");
//		System.out.println(file); null 이 뜨면 form 태그에서 빠진게 있다는 뜻 (enctype 꼭 지정할 것)
		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : " + file.getName());
		
		fileUpload(file);
		
		return "redirect:/";
	}
	
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		
		for(MultipartFile file: files) {
			fileUpload(file);
		}
		
		return "redirect:/";
	}
	
	
	



	
	@PostMapping("/update")
	public String update(Board vo) throws IllegalStateException, IOException {
		// no, url 은 프론트 단에서 hidden으로 받아오기
				
//		System.out.println(vo.getFile().isEmpty());
		if(!vo.getFile().isEmpty()) {
			// 파일이 비어있지 않다면 기존 이미지 삭제(delete 메서드 사용)
			
			if(vo.getUrl()!=null) {
			// 기존 url 을 갖고 있는 경우
			File file = new File(path + vo.getUrl());
			file.delete();
			
			}
			
			// 새 이미지 등록
			String url = fileName(vo.getFile());
			vo.setUrl(url);
		}
		
		// 파일이 비어있으면 그대로 수정 적용
		service.update(vo);
		
		return "redirect:/list";
	}
	
	@GetMapping("/delete") // "/delete?no=${board.no}" no만 가지고 있음
	public String delete(int no) {
		
		// 업로드한 파일 삭제 (url 필요)
		Board board = service.detail(no);
		
		if(board.getUrl()!=null) {
			// url을 갖고 있는 경우
			File file = new File(path + board.getUrl());
			file.delete();
		}
		
		service.delete(no);
		return "redirect:/list";
	}

}
