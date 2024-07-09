package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.kh.set.model.Person;

/* TreeSEt
 * - 저장과 동시에 자동 오름차순 정렬 (HashSet + 정렬)
 * - HashSet보다 데이터 추가, 삭제에 시간이 더 걸림
 * */

public class B_TreeSet {

	public void method1() {
		Set<String> set = new TreeSet<>();
		
		set.add("이제훈");
		set.add("구교환");
		set.add("홍사빈");
		set.add("이제훈");
		set.add("이제훈");
		
		System.out.println(set); 
		// [구교환, 이제훈, 홍사빈] 자동 정렬
		// 중복 안됨 
		System.out.println(set.size()); // 3
		System.out.println("구교환이 포함되어 있는가? "+ set.contains("구교환"));

		set.remove("홍사빈"); // index가 없음 -> 직접 지목 후 삭제
		System.out.println(set);
		
		set.clear();
		System.out.println("비어있는지? "+set.isEmpty());
		
	}
	
	public void method2() {
		TreeSet<Person> set = new TreeSet<>();
		
		//정렬 추가해야함 (compareTO) -> 나이순 설정
		set.add(new Person("이제훈", 40));
		set.add(new Person("구교환", 41));
		set.add(new Person("홍사빈", 27));
		set.add(new Person("구교환", 41));
		set.add(new Person("구교환", 41));
		
		System.out.println(set);
		// 각 객체는 주소값으로 담기기 때문에 다 다르게 인식 -> 중복제거 안됨
		// -> 객체에 hashCode, equals 메서드 재정의 자동생성하면 인식 가능
		for(Person p : set) {
			System.out.println(p);
		}
		
		/* Iterator
		 * - 컬렉션에 저장된 요소를 접근하는데 사용하는 인터페이스
		 * - iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
		 * */
		Iterator<Person> it = set.iterator();
		while(it.hasNext()) { 
			//hasNext() : 읽어올 요소가 있는지 확인
			System.out.println(it.next());
			// next(): 다음 요소를 읽어옴
		}
	}
	
	public static void main(String[] args) {
		B_TreeSet a = new B_TreeSet();
//		a.method1();
		a.method2();
	}

}
