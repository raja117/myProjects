package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnect {

	public Connection connectDb() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		final String url = "jdbc:mysql://localhost:3306/raja";
		final String username = "root";
		final String pwd = "root";
		Connection conn = DriverManager.getConnection(url, username, pwd);
		if (conn != null) {
			System.out.println("connected");
		} else {
			System.out.println("not connected");
		}
		return conn;
	}
	//
	// public static void main(String args[]) throws ClassNotFoundException,
	// SQLException
	// {
	// DataBaseConnect dbc = new DataBaseConnect();
	// dbc.connectDb();
	// }
}
