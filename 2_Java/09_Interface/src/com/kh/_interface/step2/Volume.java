package com.kh._interface.step2;

public interface Volume {

	// 인터페이스 구성요소 = 상수 + 추상 메서드
	
	// 인터페이스에서 멤버변수는 무조건 상수 (상수는 모두 대문자/띄어쓰기 _ 사용)
	/*public static final 이 앞에 숨어있음*/ int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 인터페이스에서 메서드는 무조건 추상 메서드
	/*public abstract 생략가능*/ void setVolume(int volume);
	
}
