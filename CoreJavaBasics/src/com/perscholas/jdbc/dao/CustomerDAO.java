package com.perscholas.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.perscholas.jdbc.Customer;

public class CustomerDAO extends AbstractDAO implements ICustomerDAO {

	public CustomerDAO() {
		// TODO Auto-generated constructor stub¨
		super();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = new Customer();
		
		try {
			ps = conn.prepareStatement(GET_CUST_BY_ID, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setEmail(rs.getString("email"));
				c.setFname(rs.getString("fname"));
				c.setLname(rs.getString("lname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
					if(ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return c;
	}

	@Override
	public void addCostumer(Customer c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCustomerById(int id) {
		// TODO Auto-generated method stub

	}

}
