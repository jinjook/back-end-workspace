package com.kh.mybatis.model.dto;

import lombok.Getter;
import lombok.Setter;

// DTO (Data Transfer Object) : 데이터 전송 객체
// 단지 전달용,, 담아서 보내기

@Getter @Setter
public class SearchDTO {
	// search의 keyword와 select를 모두 parameter값으로 보내기
	private String keyword;
	private String select;
}
