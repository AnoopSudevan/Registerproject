package com.xxx.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxx.bl.CustomerCRUD;
import com.xxx.model.Customer;
import com.xxx.model.Customer;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		Customer newcustomer = new Customer();
		try {
			newcustomer.setFname(request.getParameter("first_name"));
			newcustomer.setLname(request.getParameter("last_name"));
			newcustomer.setEmailID(request.getParameter("email"));
			String pass = request.getParameter("user-password").toString();
			String cpass = request.getParameter("password_confirmation").toString();
			if (pass.equals(cpass)) {
				newcustomer.setUser_Password(pass);
				CustomerCRUD C = new CustomerCRUD();
				if (C.addcustomer(newcustomer)) {
					request.setAttribute("status", true);
					request.setAttribute("message", "Inserted successfully");
					request.setAttribute("newcustomer", new Customer());
				} else {
					request.setAttribute("status", true);
					request.setAttribute("message", "Not Inserted successfully");
					request.setAttribute("newcustomer", newcustomer);
				}
			} else {

				request.setAttribute("status", true);
				request.setAttribute("message", "Password and Confirm password doesnot match");
				request.setAttribute("newcustomer", newcustomer);
			}
		} catch (Exception e) {
			if (e.getMessage().contains("primary key")) {
				request.setAttribute("status", true);
				request.setAttribute("message", "Email ID Already exists");
				request.setAttribute("newcustomer", newcustomer);
				System.err.println(e.getMessage());
			} else {
				request.setAttribute("status", true);
				request.setAttribute("message", "Server Error contact Admin");
				request.setAttribute("newcustomer", newcustomer);
				System.err.println(e.getMessage());
			}

		}
		rd=request.getRequestDispatcher("views/index.jsp");
		rd.forward(request, response);	
	}
}
