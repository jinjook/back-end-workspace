package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;

public class Application {

	Scanner sc = new Scanner(System.in);
	Employee viewEmployee = new Employee();
	EmployeeController employeeController = new EmployeeController();
	
	int empNo = 0;
	String name = "";
	char gender = 0;
	String phone = "";
	String dept = "";
	int salary = 0;
	double bonus = 0;
	
	public static void main(String[] args) {
		
		Application app = new Application();
		boolean check = true;
		while(check) {
			int select = app.employeeMenu();
			switch(select) {
				case 1:
					app.insertEmp();
					break;
				case 2:
					app.updateEmp();
					break;
				case 3: 
					app.printEmp();
					break;
				case 9: 
					System.out.println("프로그램을 종료합니다.");
					check = false;
					break;
				default : 
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
		
	}
		
	// 메인 메뉴를 출력하는 method
	public int employeeMenu() {
		System.out.println("1. 사원 정보 추가");
		System.out.println("2. 사원 정보 수정");
		System.out.println("3. 사원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
		
	// 저장할 데이터를 사용자에게 받는 method
	// viewEmployee 사용 -> javascript로 바꿀때 이용..?
	public void insertEmp() {
		System.out.print("사원 번호 : ");
//		empNo = Integer.parseInt(sc.nextLine());
		viewEmployee.setEmpNo(Integer.parseInt(sc.nextLine()));
		System.out.print("사원 이름 : ");
//		name = sc.nextLine();
		viewEmployee.setName(sc.nextLine());
		System.out.print("사원 성별 : ");
//		gender = sc.nextLine().charAt(0);
		viewEmployee.setGender(sc.nextLine().charAt(0));
		System.out.print("전화 번호 : ");
//		phone = sc.nextLine();
		viewEmployee.setPhone(sc.nextLine());
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		char add = sc.nextLine().charAt(0);
		if (add == 'y') {
			System.out.print("사원 부서 : ");
			dept = sc.nextLine();
			System.out.print("사원 연봉 : ");
			salary = Integer.parseInt(sc.nextLine());
			System.out.print("보너스 율 : ");
			bonus = Double.parseDouble(sc.nextLine());
//			employeeController.add(empNo, name, gender, phone, dept, salary, bonus);
			employeeController.add(viewEmployee.getEmpNo(), viewEmployee.getName(), viewEmployee.getGender(), viewEmployee.getPhone(), viewEmployee.getDept(), viewEmployee.getSalary(), viewEmployee.getBonus());
		} else {
//			employeeController.add(empNo, name, gender, phone);
			employeeController.add(viewEmployee.getEmpNo(), viewEmployee.getName(), viewEmployee.getGender(), viewEmployee.getPhone());
		}
	}
		

	// 수정할 데이터를 사용자에게 받는 method
	public void updateEmp() {
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화 번호");
		System.out.println("2. 사원 연봉");
		System.out.println("3. 보너스 율");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		if(num == 1) { // switch로도 가능
			System.out.print("전화 번호 입력 : ");
			phone = sc.nextLine();
			employeeController.modify(phone);
		} else if (num == 2) {
			System.out.print("사원 연봉 입력 : ");
			salary = Integer.parseInt(sc.nextLine());
			employeeController.modify(salary);
		} else if (num == 3) {
			System.out.print("보너스 율 입력 : ");
			bonus = sc.nextDouble();
			sc.nextLine();
			employeeController.modify(bonus);
	}
				
	}
			
	// 데이터를 출력하는 method
	public void printEmp() {
		System.out.println(employeeController.info());
	}
			
			
			
		/* 내가 짠 코드
		 * while(true) {
			System.out.println("1. 사원 정보 추가");
			System.out.println("2. 사원 정보 수정");
			System.out.println("3. 사원 정보 출력");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호를 누르세요 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			int empNo = 0;
			String name = "";
			char gender = 0;
			String phone = "";
			String dept = "";
			int salary = 0;
			double bonus = 0;
			
			if(num == 1) {	
				System.out.print("사원 번호 : ");
				empNo = Integer.parseInt(sc.nextLine());
				System.out.print("사원 이름 : ");
				name = sc.nextLine();
				System.out.print("사원 성별 : ");
				gender = sc.nextLine().charAt(0);
				System.out.print("전화 번호 : ");
				phone = sc.nextLine();
				System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
				char yn = sc.nextLine().charAt(0);
				if (yn == 'y') {
					System.out.print("사원 부서 : ");
					dept = sc.nextLine();
					System.out.print("사원 연봉 : ");
					salary = Integer.parseInt(sc.nextLine());
					System.out.print("보너스 율 : ");
					bonus = sc.nextDouble();
					sc.nextLine();
				}
			} else if (num == 2) {
				System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
				System.out.println("1. 전화 번호");
				System.out.println("2. 사원 연봉");
				System.out.println("3. 보너스 율");
				System.out.println("9. 돌아가기");
				System.out.print("메뉴 번호를 누르세요 : ");
				int num2 = Integer.parseInt(sc.nextLine());
				if(num2 == 1) {
					System.out.print("전화 번호 입력 : ");
					phone = sc.nextLine();
				} else if (num2 == 2) {
					System.out.println("사원 연봉 입력 : ");
					salary = Integer.parseInt(sc.nextLine());
				} else if (num2 == 3) {
					System.out.println("보너스 율 입력 : ");
					bonus = sc.nextDouble();
					sc.nextLine();
				}
			} else if (num == 3) {
				employeeController.add(empNo, name, gender, phone, dept, salary, bonus);
				System.out.println(employeeController.info());
			} else if (num == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
	}*/

}





