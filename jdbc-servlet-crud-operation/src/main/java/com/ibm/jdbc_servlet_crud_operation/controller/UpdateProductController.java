package com.ibm.jdbc_servlet_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class UpdateProductController {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            // Step-1 Load/Register Driver
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            // Step-2 Create connection
            String url = "jdbc:mysql://localhost:3306/jdbc-a14";
            String user = "root";
            String pass = "root";

            connection = DriverManager.getConnection(url, user, pass);

            // Step-3 Create statement
            statement = connection.createStatement();

            String updateProductQuery =
                    "UPDATE product SET expd = '2027-09-25' WHERE id = 2556";

            // Step-4 Execute query
            int a = statement.executeUpdate(updateProductQuery);

            String msg = a != 0 ? "Data updated" : "Something went wrong";
            System.out.println(msg);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step-5 Close resources
            try {
                if (statement != null)
                    statement.close();

                if (connection != null)
                    connection.close();

                System.out.println("Connection closed successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
