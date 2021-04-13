package com.users.services;

import com.users.entity.Stores;

public class TryStuff {

	public static void main(String[] args) {
		
		ManageStores ms = new ManageStores();
		Stores s1 = new Stores(1,"hhee", "jklsnl", "adas");
		Stores s2 = new Stores(1,"hhee", "jklsnl", "adas");
		
		boolean store = s1.equals(s2);
		
		System.out.println(store);
		
		

	}

}
