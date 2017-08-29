package com.action;

import java.sql.SQLException;
import java.sql.Statement;

public class UserLoginDetailsAction {
	
	private String email;
	private String password;
	private int userId;
	
	private String insert_user_login_details = "insert into user_login_details (user_email, user_password, fk_user_id) values('"
												+ email + "','" + password + "','" + userId + "')";
	
	public UserLoginDetailsAction() {
	    
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public boolean createUserLoginData(Statement stmt)
	{
		try {
			stmt.executeUpdate(insert_user_login_details);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
