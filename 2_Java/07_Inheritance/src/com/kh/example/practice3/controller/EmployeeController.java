package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController {
	
	private Employee employee = new Employee();
	
	// 매개변수 갯수가 다르거나, 타입이 다른 경우 -> 메서드 명을 동일하게 사용가능 : 오버로딩 
	public void add(int empNo, String name, char gender, String phone) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
	}
	
	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonus(bonus);	
	}
	
	public void modify(String phone) {
		employee.setPhone(phone);
	}
	
	public void modify(int salary) {
		employee.setSalary(salary);
	}
	
	public void modify(double bonus) {
		employee.setBonus(bonus);
	}

	public Employee info() {
		return employee;
		// 개발중일때(뭘 return할지 아직 모를때)는 return null;로 초기화해두면 에러 안생김
		// String도 클래스 -> 클래스를 리턴타입으로 설정할 수 있음
	}
}
