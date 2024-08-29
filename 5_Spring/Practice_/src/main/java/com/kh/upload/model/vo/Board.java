package com.kh.upload.model.vo;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class Board {
	private int no;
	private String title;
	private String content;
	
	
}
