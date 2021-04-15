package com.tests.users;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.users.entity.Stores;
import com.users.services.ManageStores;




class TestStores {
	private static ManageStores mu;
	static int id;
	@BeforeAll
	static void setUp()  {
		mu  =new ManageStores();
		id = mu.getRows()+1;
	}

	@ParameterizedTest
	@ValueSource(strings = {"New York", "Charlotte", "Statesville"})

	void testCities(String city) {
		List<Stores> test = mu.getAllByCity(city);
		for(Stores s: test) {
			System.out.println("Running test on city: " + city);
			assertEquals(city, s.getCity());
		}
	}
	@Test
	void testAdd() {
		
		Stores expected = new Stores(id, "TestStore", "Sun City","XX");
		
		mu.addStore(id, "TestStore", "Sun City","XX");
		List<Stores> stores = mu.getAll();
		Stores actual = stores.get(stores.size()-1);
		
		assertEquals(expected, actual);
		
	}
	@AfterAll
	static void closeDown() {
		System.out.println("AfterAll cleanup running!");
		mu.deleteById(id); 
		mu.endAll();
	}

}
