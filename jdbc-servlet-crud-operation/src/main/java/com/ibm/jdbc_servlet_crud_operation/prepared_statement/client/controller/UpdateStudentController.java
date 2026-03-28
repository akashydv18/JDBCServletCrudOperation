package com.ibm.jdbc_servlet_crud_operation.prepared_statement.client.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao.StudentDao;
import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dto.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/updateStudent")
public class UpdateStudentController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		student.setPassword(pass);
		student.setAddress(address);
		student.setPhone(phone);
		student.setDob(dob);

		StudentDao dao = new StudentDao();
		
		dao.updateStudentDao(student);
		
		resp.sendRedirect("student-display.jsp");
	}
}
