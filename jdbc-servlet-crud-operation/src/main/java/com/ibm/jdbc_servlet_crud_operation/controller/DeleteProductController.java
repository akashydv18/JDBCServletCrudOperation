package com.ibm.jdbc_servlet_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteProductController {
	
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
	
		try {
			//Step-1 Load/Register Driver
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			
			//Srtep-2 Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-a14";
			String user="root";
			String pass="root";
			
		 connection = DriverManager.getConnection(url, user, pass);
			
			//Step-3 create statement
		 statement=connection.createStatement();
			
			//Step-4 execute query
			String deleteProductQuery="delete from product where id= 292";
			
		int a= statement.executeUpdate(deleteProductQuery);
		 
		 String msg = a!=0?"deleted":"Something went wrong";
		 
		 System.out.println(msg);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			
			try {
				if(statement!=null) {
					statement.close();
				}
				if(connection!=null) {
					connection.close();
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
	}

}
