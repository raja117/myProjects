package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.action.BankDetailsAction;
import com.action.UserDetailsAction;
import com.action.UserLoginDetailsAction;

public class SignUpAction {

	public boolean signUpUser(HttpSession session, ServletContext context) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(context.getInitParameter("url"),
				context.getInitParameter("username"), context.getInitParameter("password"));
		// DataBaseConnect dbc = new DataBaseConnect();
		// Connection conn = dbc.connectDb();
		if (conn != null) {
			try {
				String get_All_EmailId = "select user_email from user_login_details";

				Statement stmt = conn.createStatement();
				UserDetailsAction uda = new UserDetailsAction();
				uda.setName(session.getAttribute("name").toString());
				uda.setGender(session.getAttribute("gender").toString());
				uda.setAddress(session.getAttribute("addr").toString());
				uda.setCity(session.getAttribute("city").toString());
				uda.setState(session.getAttribute("state").toString());
				uda.setCountry(session.getAttribute("country").toString());

				uda.createUserPersonalDetails(stmt);

				int user_id = uda.getUserId(stmt);

				if (user_id != 0) {

					BankDetailsAction bda = new BankDetailsAction();
					bda.setUserId(user_id);
					bda.setBankName(session.getAttribute("bank_name").toString());
					bda.setAccountNo(session.getAttribute("acno").toString());
					bda.setSsn(session.getAttribute("ssn").toString());

					bda.createBankDetailsForUser(stmt);

					UserLoginDetailsAction ulda = new UserLoginDetailsAction();
					ulda.setEmail(session.getAttribute("email").toString());
					ulda.setPassword(session.getAttribute("pwd").toString());
					ulda.setUserId(user_id);

					ulda.createUserLoginData(stmt);
				}
				conn.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println("Connection Not Created");
			return false;
		}

	}
}