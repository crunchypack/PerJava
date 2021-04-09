package com.perscholas.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AbstractDAO {
	
	private final String url ="jdbc:mariadb://localhost:3306/";
	private final String user = "root";
	private final String pass ="Immortal90";
	
	Connection conn = null;
	PreparedStatement ps = null;
	
	public AbstractDAO() {
		try {
			connect();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}

	public void connect(){
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	public void preparedStatement(String query) {
		try {
			this.ps = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dispose() throws SQLException{
		if(conn != null) {
			conn.close();
		}
	}
}
