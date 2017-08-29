package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class LoginAction {
	public boolean login(String email, String password, ServletContext context)
	{
		String user_Password=null;
		DataBaseConnect db = new DataBaseConnect();
		try {
			Connection conn = db.connectDb();
			Statement stmt = conn.createStatement();
			String sql = "Select user_password from table user_login_details where user_email='"+email+"'";

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				user_Password = rs.getString(1);
			}
			if(user_Password != null && user_Password.equals(password))
			{
				return true;
			}
			else
			{
				return false;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
