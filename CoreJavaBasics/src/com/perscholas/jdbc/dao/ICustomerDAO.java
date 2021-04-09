package com.perscholas.jdbc.dao;

import com.perscholas.jdbc.Customer;

public interface ICustomerDAO {
	
	public static final String GET_CUST_BY_ID = "SELECT * FROM customer WHERE id = ?";
	public static final String ADD_CUSTOMER ="INSERT INTO customer values (?,?,?,?)";
	
	public Customer getCustomerById(int id);
	public void addCostumer(Customer c);
	public void removeCustomerById(int id);
}
