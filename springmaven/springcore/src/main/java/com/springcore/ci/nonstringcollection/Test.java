package com.springcore.ci.nonstringcollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ci/nonstringcollection/nonstringciconfig.xml");
		Question q = (Question)context.getBean("que");
		
		q.displayInfo();
	}

}
