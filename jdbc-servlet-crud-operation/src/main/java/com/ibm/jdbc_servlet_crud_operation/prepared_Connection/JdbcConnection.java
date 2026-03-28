package com.ibm.jdbc_servlet_crud_operation.prepared_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class JdbcConnection {

	public static void main(String[] args) {
		
	}
	
	public static Connection getConnection() {
		try {
			   
			   //step-1 Load/Register Driver Software
			Driver driver = new Driver();
			   DriverManager.registerDriver(driver);
			// step-2 create connecton
				String url = "jdbc:mysql://localhost:3306/jdbc-a14";
				String user = "root";
				String pass= "root";
			    
			     return DriverManager.getConnection(url, user,pass);
			   
		   } catch (SQLException e) {		
			e.printStackTrace();
			
			return null;
		   }

}
}


