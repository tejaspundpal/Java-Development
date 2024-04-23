package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/lifecycleconfig.xml");
//		Car c = (Car)context.getBean("car1");
		
//		System.out.println(c);
		context.registerShutdownHook();
		
//		Bike b = (Bike)context.getBean("bike1");
//		System.out.println(b);
		
		Example ex = (Example)context.getBean("ex1");
		System.out.println(ex);
	}

}

