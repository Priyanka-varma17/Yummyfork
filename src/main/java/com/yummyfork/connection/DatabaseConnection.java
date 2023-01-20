package com.yummyfork.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DRIVER_PATH="com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/YummyFork";
	private static final String USERNAME="root";
	private static final String PASSWORD="";

	
	public DatabaseConnection() {
		
		try {
			Class.forName(DRIVER_PATH);
		}
		catch(ClassNotFoundException e) {
			throw new RuntimeException("Something went wrong "+e);

		}
	}
	
	public Connection getConnection()throws SQLException{
		
		return DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
	}
}
