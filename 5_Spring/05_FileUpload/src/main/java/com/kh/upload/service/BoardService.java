package com.kh.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

import mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	public void insert(Board bo) {
		mapper.insert(bo);
	}
	
	public List<Board> allList(Paging paging){
		
		/*
		 * 기본 limit 가 10인 경우로 지정되어있음
		 * page = 1일때 -> offset = 0
		 * page = 2가 되면 -> offset = 10이 되어야함
		 * page = 3 -> offset = 20 ...
		 * 
		 * offset = limit * (page - 1)
		 * */
		
		paging.setOffset(paging.getLimit() * (paging.getPage() - 1));
		
		return mapper.allList(paging);
	}
	
	public int total() {
		return mapper.total();
	}
	
	public Board detail(int no) {
		return mapper.detail(no);
	}
	
	// public 붙어야 다른 패키지에서 호출 가능 
	public void update(Board vo) {
		mapper.update(vo);
	}
	
	public void delete(int no) {
		mapper.delete(no);
	}
}
