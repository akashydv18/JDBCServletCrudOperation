package com.ibm.jdbc_servlet_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.mysql.cj.jdbc.Driver;

public class DisplayProductController {
   public static void main(String[] args) {
	
	   
	  // step-1 Load/Register Driver   
	   try {
	 Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		// step-2 create connecton
		String url = "jdbc:mysql://localhost:3306/jdbc-a14";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);


		// step-3 create Statement to send sql query to database
		Statement statement = connection.createStatement();
		
		//step-4 Execute query 
		String displayProductQuery= "Select * FROM product where id= 250";
		
		 ResultSet resultSet= statement.executeQuery(displayProductQuery);
		 
		 //step-5 Process the result
		 int i=1;
		 while(resultSet.next()) {
			 System.out.println("........."+ i++ + "..........");
			 int id= resultSet.getInt("id");
			 String name= resultSet.getString("name");
			 String color= resultSet.getString("color");
			 double price= resultSet.getDouble("price");
			 
			 LocalDate mfd= resultSet.getDate("mfd").toLocalDate();
			 LocalDate expd= resultSet.getDate("expd").toLocalDate();
			 
			 String brand= resultSet.getString("brand");
			 
			 int stock= resultSet.getInt("stock");
			 
			 System.out.println("id = "+id);
			 System.out.println("name = "+name);
			 System.out.println("color= "+color);
			 System.out.println("price = "+price);
			 System.out.println("mfd = "+mfd);
			 System.out.println("expd = "+expd);
			 System.out.println("brand = "+brand);
			 System.out.println("stock = "+stock);
			 
		 }
		
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
}
}
