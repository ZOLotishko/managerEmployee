package com.bigcompany.managerEmployee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class MYSQLConnection {
	
	private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/todo" ;	
	
	public static Connection getConnection(){
		
		
		
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection connection = null;
		
		try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		return connection;	
		
	}
}
