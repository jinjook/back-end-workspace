package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.domain.Movie;
import com.jpa.repo.MovieDAO;

@Service
public class MovieService {
	
	// DAO 주입
	@Autowired
	private MovieDAO dao;
	
	// C - 추가
	public void change(Movie vo) {
		dao.save(vo);
		// save : id(primary key)가 없으면 추가/ id가 있으면 수정으로 사용
	}
	
	// R - 전체 조회
	public List<Movie> viewAll() {
		return dao.findAll();
	}
	
	// R - 1개 보기
	public Movie view(int id) {
		return dao.findById(id).orElse(null);
				//.orElse(null) : Movie 타입이 아닐 경우 null로 반환
				//.get(): 없는거 조회할때 500에러 뜸
	}
	
	// D - 삭제
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
}
