package com.spring.practise;

public class ContactInfo {

	private String city;
	private String state;
	private String country;
	private String firstName;
	private String lastName;
	private String middleName;
	private String Gender;
	
	private PersonalInfo pf;
	
	public ContactInfo(PersonalInfo pf)
	{
		this.pf = pf;
		this.firstName = pf.getFirstName();
		this.lastName = pf.getLastName();
		this.middleName = pf.getMiddleName();
		this.Gender = pf.getGender();
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = pf.getLastName();
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = pf.getMiddleName();
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = pf.getGender();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = pf.getFirstName();
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
