package com.kh.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.model.vo.Board;

import mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	public List<Board> allList(){
		return mapper.allList();
	}
	
	public void insertBoard(Board board) {
		mapper.insertBoard(board);
	}
	
	public Board selectList(int no) {
		return mapper.selectList(no);
	}
	
	public void updateContent(Board bo) {
		mapper.updateContent(bo);
	}
	
	public void deleteContent(int no) {
		mapper.deleteContent(no);
	}
}
