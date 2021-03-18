package com.perscholas.java_arrays;

public class DailyTasks {

	public static void main(String[] args) {
		taskThree();
	}
	
	public static void taskOne() {
		int[] i = {1,2,3};
		for(int j = 0; j < i.length; j++) {
			System.out.println(i[j]);
		}
	}
	public static void taskTwo() {
		int[] i = {13,5,7,68,2}; 
		System.out.println(i[i.length/2]);
	}
	public static void taskThree() {
		int[] i = {5,10,15,20,25}; 
		System.out.println(i[0]);
		System.out.println(i[i.length-1]);
		System.out.println(i[i.length]);
		i[5] = 10;
	}
}
