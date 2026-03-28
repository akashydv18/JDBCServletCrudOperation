package com.ibm.jdbc_servlet_crud_operation.prepared_statement.controller;

import java.time.LocalDate;
import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao.StudentDao;
import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dto.Student;

public class InsertStudentControlller {

	public static void main(String[] args) {
		Student student = new Student();

		StudentDao dao= new StudentDao();
			
		student.setId(7890);
		student.setName("Kailash");
		student.setEmail("kailash@gmail.com");
		student.setPhone(65789354);
		student.setPassword("kailash@123");
		student.setAddress("noida sector 16");
		student.setDob(LocalDate.parse("1998-09-13"));
		
		int a = dao.saveStudentDao(student);
		
		String msg= a!=0?"data stored":"something went wrong check your code";
		
		System.out.println(msg);
	}

}
