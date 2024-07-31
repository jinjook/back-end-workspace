package com.kh.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data @AllArgsConstructor
public class Member {
	private String id;
	private String pwd;
	private String name;
}