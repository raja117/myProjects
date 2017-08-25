package com.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDetailsAction {

	private String name;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String country;
	
	private String insert_user_details = "insert into user_details (name, gender, address, city, state, country) values ('"
										 + name + "','" + gender + "','" + address + "','" + city + "','"
										 + state + "','" + country + "')";
	
	private String get_user_id = "select user_id from user_details order by user_id";
	
	
	public UserDetailsAction() {
	}

	public UserDetailsAction(String name, String gender, String address, String city, String state, String country) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public boolean createUserPersonalDetails(Statement stmt) {
			
		try{
			stmt.executeUpdate("insert into user_details (name, gender, address, city, state, country) values ('"
				 + name + "','" + gender + "','" + address + "','" + city + "','"
				 + state + "','" + country + "')");
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();;
			return false;
		}
	}

	public int getUserId(Statement stmt) throws SQLException {

		ResultSet rs = stmt.executeQuery(get_user_id);
		int user_id = 0;
		while (rs.next()) {
			user_id = rs.getInt(1);
		}
		return user_id;
	}
}