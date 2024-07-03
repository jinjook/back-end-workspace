package com.kh.step1.model;

// TV의 코드화
public class Tv {
	
	// TV 기능이 더 있지만(음량, 음소거 등) 당장 프로그래밍화 하는데 필요한 속성과 기능만 뽑아옴 => 추상화
	
	// 속성(property) : 멤버변수(member variable), 특성(attribute), 필드(field) - 같은말
	public boolean power; // 전원상태(on/off) 설정
	public int channel; // 채널 번호
	
	
	// 기능(function) : 메서드(method), 함수(function) - 같은말
	public void power() {
		power = !power; // TV를 끄거나 키는 기능 : 켜져있으면 끄고, 꺼져있으면 켜지게 설정
	}
	
	public void channelUp() {
		++channel; // 채널 번호를 높이는 기능
	}
	
	public void channelDown() {
		--channel; // 채널 번호를 내리는 기능
	}
	
	
}
