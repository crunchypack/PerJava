package com.perscholas.java_key;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WareHouse {
	private List<Door> doors = new ArrayList<Door>();
	public WareHouse() {
		for(int i = 0; i<=100;i++) {
			Door d;
			if(i < 10) {
				d = new Door(null);
			}else {
				Random r = new Random();
		        int num = r.nextInt((3 - 0) + 1) + 0;
		        KeyShape ks;
		        
				switch(num) {
				case 0:
					ks = KeyShape.Square;
					break;
				case 1:
					ks = KeyShape.Circular;
					break;
				case 2:
					ks = KeyShape.Oval;
					break;
				case 3:
					ks = KeyShape.TrapezoidDown;
					break;
				default: 
					System.out.println("Something went wrong!");
					ks = KeyShape.Unknown;
					break;
				}
				Key k = new Key(ks);
				d = new Door(k);
			}
			doors.add(d);
		}
	}
	
	public void displayDoors() {
		for(Door d : doors) {
			if(d.hasKey()) {
				System.out.println("Lockable door, the key has a " + d.getKey().shape() + " shape.");
			}
			else {
				System.out.println("Door has no key");
			}
		}
	}


}
