package com.kh.overriding;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VIPCustomer;

public class Application {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("김경주");
		Customer customer2 = new Customer("김경주");
		
		"김먼지".equals("김먼지"); // Object 클래스 (String 클래스 안에서 equals로 재정의)
		
		System.out.println(customer1);
		System.out.println(customer2);
		
		System.out.println(customer1 == customer2); // false 
		System.out.println(customer1.equals(customer2)); // false -> 재정의해서 true로 바꿀 수 있음 (Customer에서 equals 사용)
		
		// ~~님의 등급은 ~~이며, 지불해야 하는 금액은 ~원이며, 적립된 포인트는 ~~점입니다.
		
		System.out.println(customer1.getName()+"님의 등급은 "+customer1.getGrade()+"이며, 지불해야 하는 금액은 "+customer1.calcPrice(10000)+"원이며, 적립된 포인트는 "+customer1.getBonusPoint()+"점입니다.");
		
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.\n",
							customer2.getName(), customer2.getGrade(), customer2.calcPrice(10000), customer2.getBonusPoint());
		
		
		VIPCustomer customer3 = new VIPCustomer("김먼지");
		VIPCustomer customer4 = new VIPCustomer("김먼지");
		
		System.out.println(customer3.equals(customer4)); // 부모인 customer에서 equals 재정의 적용했기 때문에 true
		
		
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다.\n",
				customer3.getName(), customer3.getGrade(), customer3.calcPrice(10000), customer3.getBonusPoint());
		

	}

}
















