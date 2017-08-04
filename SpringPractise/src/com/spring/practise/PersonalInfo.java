package com.spring.practise;

public class PersonalInfo {

	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	
	public void init(){
		//setFirstName("raja");
		System.out.println(getFirstName());
		System.out.println("in init method");
	}
	
	public void destroy(){
		System.out.println("in destroy method");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
