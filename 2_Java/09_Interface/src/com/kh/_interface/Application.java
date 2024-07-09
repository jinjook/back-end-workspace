package com.kh._interface;

import com.kh._interface.step1.Bus;
import com.kh._interface.step1.Taxi;
import com.kh._interface.step1.Vehicle;
import com.kh._interface.step2.Audio;
import com.kh._interface.step2.Tv;

/* 인터페이스 (interface)
 * 
 * [접근제어자] interface 인터페이스명 { }
 * 
 * - 인터페이스는 개발 코드와 객체가 서로 통신하는 접점 역할을 한다.
 * - 인터페이스에서 변수는 무조건 상수이다.
 * - 인터페이스에서 메서드는 무조건 추상메서드이다.
 * - 객체가 구현해야 하는 기능이 있을 때 인터페이스에 추상 메서드를 추가해서 
 * 	 객체가 기능을 구현하도록 만들 수 있다.
 * - 인터페이스를 구현하려면 implements 키워드 사용
 * - 인터페이스는 다중 상속(구현)을 허용
 * - 추상 클래스보다 더 강한 규칙성, 강제성을 가짐
 * 
 * 추상클래그와 인터페이스
 * 공통점
 * - 객체 생성 불가, 참조 변수로는 사용 가능 (즉, 다형성 적용 가능)
 * - 상속하는 클래스에서 추상 메소드를 재정의하도록 강제
 * 
 * 차이점
 * - 추상클래스는 abstract 키워드로 클래스 정의 / 클래스 내에 변수, 메서드 생성 가능
 * - 인터페이스는 interface 키워드로 클래스 정의 / 인터페이스 내에 변수, 메서드 생성 불가능
 * - 추상클래스는 클래스 -> extend 사용 / 인터페이스는 엄연히 말하자면 상속보다는 구현관계 -> implements 사용
 * 
 * extends 와 implements
 * - 클래스간의 상속 관계일 때 : 자식 클래스명 extends 부모 클래스명
 * - 클래스와 인터페이스의 구현 관계일 때 : 구현 클래스명 implements 인터페이스명, 인터페이스명, ...
 * - 인터페이스 간의 상속 관계일 때 : 인터페이스명 extends 인터페이스명, 인터페이스명, ... (클래스와 달리 여러개 상속 가능)
 * 	 (구현은 implements / 상속일땐 extends 사용)
 * */

public class Application {

	public static void main(String[] args) {

//		Vehicle v = new Vehicle(); 에러 : 인터페이스 객체 생성 불가
		Vehicle bus = new Bus();
		Vehicle taxi = new Taxi();
		
		bus.run();
		taxi.turn();
		
		System.out.println();
		
		Tv tv = new Tv();
		tv.turnOn();
		tv.setVolume(-1);
		tv.turnOff();
		System.out.println();
		
		Audio audio = new Audio();
		audio.turnOn();
		audio.search("melon.com");
		audio.setVolume(30);
		audio.turnOff();
		
		
	}
	
	/* 추상 클래스 : 미완성 설계도, 인터페이스 : 기본 설계도 
	 * 개발방법론 : 예전 - 폭포수방식(기획끝나고 디자인끝나고 개발) vs 요즘 - 애자일방식 (기획하면서 디자인하면서 개발)
	 * */

}
