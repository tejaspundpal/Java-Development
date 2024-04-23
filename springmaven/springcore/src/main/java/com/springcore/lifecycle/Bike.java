package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bike implements InitializingBean,DisposableBean {

	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Bike() {
		super();
	}

	@Override
	public String toString() {
		return "Bike [price=" + price + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//init
		System.out.println("init : bike start");
	}

	@Override
	public void destroy() throws Exception {
		//destroy
		System.out.println("destroy : bike stop");
	}
	
}
