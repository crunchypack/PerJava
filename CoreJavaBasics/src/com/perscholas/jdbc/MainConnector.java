package com.perscholas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainConnector {
	public static void main (String[] args) throws SQLException, ClassNotFoundException {
//		Class.forName("org.mariadb.jdbc.Driver");
		String url =  "jdbc:mariadb://localhost:3306/classicmodels"; 
		final String USER = "root";
		final String PASS = "Immortal90";
		Connection conn = DriverManager.getConnection(url, USER, PASS);

		String SelectSQL = "Select * FROM employees";
		Statement stmt = conn.createStatement();
		ResultSet result =  stmt.executeQuery(SelectSQL);
		while(result.next())
		                {
		                    String name = result.getString("firstName");
		                    String email  = result.getString("email");
		                    System.out.println(name +" | " + email);
		                }

	}
}
