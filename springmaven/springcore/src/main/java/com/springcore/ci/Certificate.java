package com.springcore.ci;

public class Certificate {
	public String certificateName;
	public Certificate(String certificateName) {
		this.certificateName = certificateName;
	}
	@Override
	public String toString() {
		return this.certificateName;
	}
	
	
}
