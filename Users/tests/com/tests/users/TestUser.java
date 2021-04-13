package com.tests.users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.users.entity.Users;
import com.users.services.ManageUsers;

class TestUser {
	private static ManageUsers mu;
	@BeforeAll
	public static void setUp() {
		mu = new ManageUsers();
	}

	@Test
	public void testLogin() {
		String email = "simon.lobo@gmail.com";
		String name = "simon";
		String password = "pass";
		String address = "123 Fake Street";
		String state = "NY";
		Integer zip = 10001;
		
		Users expected = new Users(email,name,password,address,state,zip);
		
		Users actual = mu.login(email, password);
		
		assertEquals(expected, actual);
	}

}
