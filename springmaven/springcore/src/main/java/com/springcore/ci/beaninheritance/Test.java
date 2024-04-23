package com.springcore.ci.beaninheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ci/beaninheritance/beaninheritance.xml");
		Employee e = (Employee)context.getBean("emp2");
		e.show();
	}

}
