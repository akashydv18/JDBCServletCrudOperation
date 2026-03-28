package com.ibm.jdbc_servlet_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProductController {
	public static void main(String[] args) {

		try { 
			// step-1 Load/Register Driver Software
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 create connecton
			String url = "jdbc:mysql://localhost:3306/jdbc-a14";
			String username = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);

			// step-3 create Statement to send sql query to database
			Statement statement = connection.createStatement();

			String insertProductQuery =" insert into product (id,name,color,price,mfd,expd,brand,stock) values(2556,'bag','black',1000,'2025-12-01','2026-05-10','american touristar',220)";
 
			// Step-4 execute query
			int a=statement.executeUpdate(insertProductQuery);
			
			String msg= a!=0?"data stored":"data not stored";
			
			  System.out.println(msg);
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
}
