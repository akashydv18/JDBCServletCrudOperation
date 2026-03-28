package com.ibm.jdbc_servlet_crud_operation.prepared_statement.client.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao.StudentDao;
import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginStudentClientController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		
		
		resp.setContentType("text/html");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Student student = new StudentDao().getStudentByEmailDao(email);

		PrintWriter printWriter = resp.getWriter();

		if (student != null) {

			if (password.equals(student.getPassword())) {

				
				httpSession.setAttribute("userSession", email);
				
				httpSession.setMaxInactiveInterval(30);
				
				RequestDispatcher dispatcher = 
						req.getRequestDispatcher("student-display.jsp");
				dispatcher.forward(req, resp);

			} else {

				printWriter.write(
						"<html><body><script>alert('check your password that is incorrect');</script></body></html>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("student-login.jsp");
				dispatcher.include(req, resp);
			}
		} else {
			printWriter
					.write("<html><body><script>alert('check your email that is incorrect');</script></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("student-login.jsp");
			dispatcher.include(req, resp);
		}
	}

}