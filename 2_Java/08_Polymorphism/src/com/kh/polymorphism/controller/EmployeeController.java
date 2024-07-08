package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.parent.Employee;

public class EmployeeController {

	// 이름으로 사람 찾기
	public Employee findEmployeeByName(String name, Employee[] empArr) {
		
		for(int i=0; i<empArr.length; i++) {
			if(name.equals(empArr[i].getName())) 
			return empArr[i];
			
		}
		return null; //  값이 없을 시 null로 출력됨
	}
	
	
	// 찾는 사람의 연봉은?
	public int getAnnualSalary(Employee e) {
		if(e instanceof Engineer) { // 특정 자식 객체 찾는 방법! 
			Engineer engineer = (Engineer) e; 
			// 엔지니어에 없는 보너스를 추가하고싶을 때, 부모 -> 자식 : 강제 형 변환
			return e.getSalary() * 12 + engineer.getBonus();
		}
		return e.getSalary()*12;	
	}
	
	// 전체 사람들의 연봉 총합은?
	public int getTotalSalary(Employee[] empArr) {
		int sum = 0;
		/*for(int i = 0; i<empArr.length; i++) {
			sum += empArr[i].getSalary()*12;
		}*/
		
		// 향상된 for문
		  for(Employee employee : empArr){
		  sum += getAnnualSalary(employee);
		  }
		 
		return sum;
	}
	
}

