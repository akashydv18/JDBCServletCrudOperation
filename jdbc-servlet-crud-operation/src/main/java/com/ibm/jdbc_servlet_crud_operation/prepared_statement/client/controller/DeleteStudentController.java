package com.ibm.jdbc_servlet_crud_operation.prepared_statement.client.controller;

import java.io.IOException;

import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/deletestudent")
public class DeleteStudentController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("delete student by id");
		
		int id =Integer.parseInt( req.getParameter("id"));
		
		boolean b=new StudentDao().deleteStudentByIdDao(id);
		
		if(b) {
			System.out.println("data deleted!!!!s =" + id);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("student-display.jsp");
		dispatcher.forward(req, resp);
	}
	
}