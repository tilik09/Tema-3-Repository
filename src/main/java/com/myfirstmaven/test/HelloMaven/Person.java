package com.myfirstmaven.test.HelloMaven;

public class Person {

	public String name;
	public String email;

	public Person(String strName, String strEmail) {
		name = strName;
		email = strEmail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
