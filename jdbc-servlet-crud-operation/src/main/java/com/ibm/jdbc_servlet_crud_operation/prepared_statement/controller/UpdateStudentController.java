package com.ibm.jdbc_servlet_crud_operation.prepared_statement.controller;

import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao.StudentDao;

public class UpdateStudentController {

	public static void main(String[] args) {
		
		int result= new StudentDao().updateStudentNameDao(7890,"Aakash");

		String msg= result!=0?"data updated":"something went wrong";
		
		System.out.println(msg);
	}

}
