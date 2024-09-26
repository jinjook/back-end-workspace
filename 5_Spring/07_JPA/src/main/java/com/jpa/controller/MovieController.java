package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.domain.Movie;
import com.jpa.service.MovieService;

@RestController
@RequestMapping("/api/*") // localhost:8080
@CrossOrigin(origins= {"*"}, maxAge=6000) // 전체허용 (localhost:3000)에서도 보일 수 있게
public class MovieController {

	//service 주입
	@Autowired
	private MovieService service;
	
	// C - 추가
	@PostMapping("/movie")
	public ResponseEntity add(@RequestBody Movie vo) {
		//form-data 방식이 아닌 JSON 방식으로 보낼때는 반드시 @RequestBody

		service.change(vo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// R - 전체조회
	@GetMapping("/movie")
	public ResponseEntity viewAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.viewAll());
	}
	
	// R - 1개 보기
	@GetMapping("/movie/{id}")
	public ResponseEntity view(@PathVariable int id) {
		// 경로에서 id 가져오기때문에 반드시 @PathVariable
		
		Movie movie = service.view(id);
		if(movie!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(service.view(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // NOT_FOUND : 404 에러로 뜸
	}
	
	// U - 수정
	@PutMapping("/movie")
	public ResponseEntity update(@RequestBody Movie vo) {
		service.change(vo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// D - 삭제
	@DeleteMapping("/movie/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
	
	
	
	
	
	
	
	
}
