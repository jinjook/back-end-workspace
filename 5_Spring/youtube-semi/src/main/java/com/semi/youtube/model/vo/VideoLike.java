package com.semi.youtube.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor 
@AllArgsConstructor @Builder // id와 videoCode만 담기 위해서 사용
public class VideoLike {
	private int likeCode;
	private String id; // member
	private int videoCode; // video
}
