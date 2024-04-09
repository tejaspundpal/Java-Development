package com.springcore.ci;
import java.util.*;

public class Person {
	private String personName;
	private int personId;
	private Certificate certificate;
	private List<String>list;
	
	public Person(String personName,int personId,Certificate certificate,List<String>list) {
		this.personName = personName;
		this.personId = personId;
		this.certificate = certificate;
		this.list = list;
	}

	@Override
	public String toString() {
		return this.personName + " : " + this.personId + " ( " + this.certificate.certificateName + ")" +this.list;
	}
	
	
}
