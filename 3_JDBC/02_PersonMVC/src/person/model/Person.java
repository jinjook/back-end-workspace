package person.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok.jar - 어노테이션으로 생성 가능

// @NoArgsConstructor - 기본 생성자
// @AllArgsConstructor - 모든 필드값 파라미터로 받는 생성자

// @Data : 아래 4개의 어노테이션들을 한꺼번에 만들어주는 어노테이션

// @RequiredArgsConstructor - 필드값에 final 이 붙어있거나 @NonNull이 붙어있는 필드들을 파라미터로 받는 생성자
// @Getter @Setter - Getter / Setter
// @ToString - toString

@Data @NoArgsConstructor 
@AllArgsConstructor
public class Person {

	private int id;
	private String name;
	private int age;
	private String addr;
	
		
}
