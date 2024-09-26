package com.semi.youtube.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Paging {
	
	private int page = 1; // 현재 페이지
	
	private int offset = 0; // 시작 위치
	private int limit = 12; // 레코드 수 (목록 수)
	
	private int pageSize = 5; // 한 페이지 당 페이지 갯수
	private int endPage = this.pageSize; // 한 페이지의 마지막 페이지 수
	private int startPage = this.page; // 한 페이지의 첫 페이지 수
	
	private boolean prev;
	private boolean next;
	
	public Paging(int page, int total) {
		/* 끝페이지부터 계산하는것 추천
		 * page : 1 ~ 10 ->  endPage : 10
		 * page : 11 ~ 20 -> endPage : 20
		 * page : 21 ~ 30 ->  endPage : 30
		 * */
		
		this.page = page;
		this.endPage = (int) Math.ceil((double) this.page / this.pageSize) * this.pageSize;
		this.startPage = this.endPage - this.pageSize +1;
		
		
		// 전체 개수를 통해 마지막 페이지 계산
		int lastPage = (int) Math.ceil((double) total/ this.limit);
		
		if(lastPage < this.endPage) {
			// endPage보다 lastPage가 작으면 해당 lastPage를 endPage로 설정
			this.endPage = lastPage;
		}
		
		
		this.prev = this.startPage > 1; 
		this.next = this.endPage < lastPage; // 일때만 true
	}
	
}