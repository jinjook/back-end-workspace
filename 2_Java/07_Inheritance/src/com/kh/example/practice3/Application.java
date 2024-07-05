package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;

public class Application {

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Application a = new Application();
		Employee viewEmployee = new Employee();
		EmployeeController employeeController = new EmployeeController();
		
		
		
		
		while(true) {
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
			
			if(num == 1) {	
				System.out.print("사원 번호 : ");
				int empNo = Integer.parseInt(sc.nextLine());
				System.out.print("사원 이름 : ");
				String name = sc.nextLine();
				System.out.print("사원 성별 : ");
				char gender = sc.nextLine().charAt(0);
				System.out.print("전화 번호 : ");
				String phone = sc.nextLine();
				System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
				char yn = sc.nextLine().charAt(0);
				if (yn == 'y') {
					System.out.print("사원 부서 : ");
					String dept = sc.nextLine();
					System.out.print("사원 연봉 : ");
					int salary = Integer.parseInt(sc.nextLine());
					System.out.print("보너스 율 : ");
					double bonus = sc.nextDouble();
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
					String phone = sc.nextLine();
				} else if (num2 == 2) {
					System.out.println("사원 연봉 입력 : ");
					int updateSalary = Integer.parseInt(sc.nextLine());
				} else if (num2 == 3) {
					System.out.println("보너스 율 입력 : ");
					double updateBonus = sc.nextDouble();
					sc.nextLine();
				}
			} else if (num == 3) {
				employeeController.add(empNo, name, gender, phone, dept, salary, bonus);
				System.out.println(viewEmployee);
			} else if (num == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
	}

}
/*	
public int employeeMenu() {
	System.out.println("1. 사원 정보 추가");
	System.out.println("2. 사원 정보 수정");
	System.out.println("3. 사원 정보 출력");
	System.out.println("9. 프로그램 종료");
	System.out.print("메뉴 번호를 누르세요 : ");
	int num = Integer.parseInt(sc.nextLine());
	return num;
}

public void insertEmp() {
		System.out.print("사원 번호 : ");
		int empNo = Integer.parseInt(sc.nextLine());
		System.out.print("사원 이름 : ");
		String name = sc.nextLine();
		System.out.print("사원 성별 : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("전화 번호 : ");
		String phone = sc.nextLine();
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		char yn = sc.nextLine().charAt(0);
		if (yn == 'y') {
				System.out.print("사원 부서 : ");
				String dept = sc.nextLine();
				System.out.print("사원 연봉 : ");
				int salary = Integer.parseInt(sc.nextLine());
				System.out.print("보너스 율 : ");
				double bonus = sc.nextDouble();
				sc.nextLine();
		}

public void updateEmp() {
	System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
	System.out.println("1. 전화 번호");
	System.out.println("2. 사원 연봉");
	System.out.println("3. 보너스 율");
	System.out.println("9. 돌아가기");
	System.out.print("메뉴 번호를 누르세요 : ");
	int num2 = Integer.parseInt(sc.nextLine());
	if(num2 == 1) {
		System.out.print("전화 번호 입력 : ");
		String phone = sc.nextLine();
	} else if (num2 == 2) {
		System.out.println("사원 연봉 입력 : ");
		int updateSalary = Integer.parseInt(sc.nextLine());
	} else if (num2 == 3) {
		System.out.println("보너스 율 입력 : ");
		double updateBonus = sc.nextDouble();
		sc.nextLine();
}*/



}
