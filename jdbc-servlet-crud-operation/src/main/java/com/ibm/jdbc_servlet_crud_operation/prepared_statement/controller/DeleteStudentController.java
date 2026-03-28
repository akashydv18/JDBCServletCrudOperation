package com.ibm.jdbc_servlet_crud_operation.prepared_statement.controller;

import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao.StudentDao;

public class DeleteStudentController {

	public static void main(String[] args) {
	
		boolean b =new StudentDao().deleteStudentByIdDao(234);
		
		String msg= b?"deleted":"something went wrong";
		
		System.out.println(msg);

	}

}
