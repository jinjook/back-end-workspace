package com.kh.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class E_SubClass extends E_SuperClass {
	
	/* # 부모 클래스의 method와 같은 Exception을 throws 하는것은 가능
	@Override
	public void method() throws IOException { }
	*/

	/* # 오버라이딩 시 throws 작성하지 않아도 가능
	@Override
	public void method() {}
	*/
	
	/* # 부모 클래스의 메서드와 다른 Exception 을 throws 하는 것은 불가능
	@Override
	public void method() throws ClassNotFoundException {}
	*/
	
	/* # 부모 클래스의 메서드 IOException 보다 더 하위 타입의 Exception인 FileNotFoundException을 throws 하는 것은 가능
	@Override
	public void method() throws FileNotFoundException {}
	*/
	
	/* # 부모가 IOException -> 보다 더 상위인 Exception 을 throws 하는것은 불가능
	@Override
	public void method() throws Exception {}
	*/
	
	
	
	
}
