package com.test.items;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Testing {
	private static TestThis test;
	@BeforeAll
	public static void setUp() {
		test = new TestThis();

	}

	@Test
	public void testGetNameAtIndex() {
		String expected = "Mike";
		
		String actual = test.getNameAtindex(0);
		
		assertEquals(expected, actual);
		
		String actual1 = test.getNameAtindex(2);
		
		assertEquals("Tony", actual1);
	}
	@Test 
	public void testAddName() {
		String expected = "Jared";
		
		test.addName(expected);
		
		String actual = test.getNameAtindex(test.getNames().size() -1);
		
		assertEquals(expected, actual);
	}
}
