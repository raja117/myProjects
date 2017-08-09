package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class SignUpAction {

	public boolean signUpUser(HttpSession session, ServletContext context) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(context.getInitParameter("url"),
				context.getInitParameter("username"), context.getInitParameter("password"));
		// DataBaseConnect dbc = new DataBaseConnect();
		// Connection conn = dbc.connectDb();
		if (conn != null) {
			try {
				String insert_user_details = "insert into user_details(name, gender, address, city, state, country) values ('"
						+ session.getAttribute("name") + "','" + session.getAttribute("gender") + "','"
						+ session.getAttribute("addr") + "','" + session.getAttribute("city") + "','"
						+ session.getAttribute("state") + "','" + session.getAttribute("country") + "')";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(insert_user_details);

				int user_id = getUserId(stmt);

				if (user_id != 0) {
					String insert_user_bank_details = "insert into user_bank_details(bank_name,acc_no,ssn,fk_user_id) values ('"
							+ session.getAttribute("bank_name") + "','" + session.getAttribute("acno") + "','"
							+ session.getAttribute("ssn") + "','" + user_id + "')";
					stmt.executeUpdate(insert_user_bank_details);

					String insert_user_login_details = "insert into user_login_details (user_email, user_password, user_id) values('"
							+ session.getAttribute("email") + "','" + session.getAttribute("pwd") + "','" + user_id
							+ "')";
					stmt.executeUpdate(insert_user_login_details);
				}
				conn.close();
				return true;
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println("Connection Not Created");
			return false;
		}

	}

	public int getUserId(Statement stmt) throws SQLException {

		String sql = "select user_id from user_details order by user_id";
		ResultSet rs = stmt.executeQuery(sql);
		int user_id = 0;
		while (rs.next()) {
			user_id = rs.getInt(1);
		}
		return user_id;
	}
}
