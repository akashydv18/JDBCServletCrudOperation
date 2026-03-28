package com.ibm.jdbc_servlet_crud_operation.prepared_statement.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao.StudentDao;
import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentClientController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setPhone(phone);
		student.setPassword(pass);
		student.setAddress(address);
		student.setDob(dob);

		StudentDao dao = new StudentDao();

		int a = dao.saveStudentDao(student);

		PrintWriter printWriter = resp.getWriter();

		if (a != 0) {
	
			printWriter.write("<html><body><script>alert('you are registered')</script></body></html>");
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("student-login.jsp");
			dispatcher.include(req, resp);

		} else {
			System.out.println("something went wrong");
			printWriter.write("<html><body><script>alert('something went wrong')</script></body></html>");
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("student-login.jsp");
			dispatcher.include(req, resp);
		}

	
	}

}
