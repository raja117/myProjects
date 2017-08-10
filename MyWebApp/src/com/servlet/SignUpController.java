package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.SignUpAction;

/**
 * Servlet implementation class Weather
 */
@WebServlet("/Weather")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("hid").equalsIgnoreCase("personal_info"))
		{
			session.setAttribute("name", (request.getParameter("lastname")+" "+request.getParameter("firstname")+" "+request.getParameter("middlename")));
			session.setAttribute("gender", request.getParameter("gender"));
			response.sendRedirect("contactinfo.html");
		}
		else if(request.getParameter("hid").equals("contact_info"))
		{
			session.setAttribute("email", request.getParameter("email"));
			session.setAttribute("pwd", request.getParameter("pwd"));
			session.setAttribute("addr", request.getParameter("addr"));
			session.setAttribute("city", request.getParameter("city"));
			session.setAttribute("state", request.getParameter("state"));
			session.setAttribute("country", request.getParameter("country"));
			session.setAttribute("phno", request.getParameter("phnumb"));
			response.sendRedirect("bankinfo.html");
		}

		else if(request.getParameter("hid").equalsIgnoreCase("bank_info"))
		{
			session.setAttribute("bank_name", request.getParameter("bankname"));
			session.setAttribute("acno", request.getParameter("acno"));
			session.setAttribute("ssn", request.getParameter("ssn"));
			ServletContext context = getServletContext();
			SignUpAction sa = new SignUpAction();
			try {
				if(sa.signUpUser(session, context)){
					session.invalidate();
					response.sendRedirect("success.html");
				}
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
