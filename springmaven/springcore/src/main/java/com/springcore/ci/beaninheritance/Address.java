package com.springcore.ci.beaninheritance;

public class Address {
	private String lane,city,state,country;  
	  
	public Address(String lane, String city, String state, String country) {  
	    super();  
	    this.lane = lane;  
	    this.city = city;  
	    this.state = state;  
	    this.country = country;  
	}  
	public String toString(){  
	    return lane+" "+city+" "+state+" "+country;  
	}  
}
