package com.perscholas.java_arrays;

import java.util.Arrays;

public class DailyTasks {

	public static void main(String[] args) {
		
		taskTen();
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
		String[] colors = {
			"red",
			"green",
			"blue",
			"yellow"
		};
		System.out.println(colors.length);
		String[] newColors = colors.clone();
		System.out.println(Arrays.toString(newColors));
	}
	public static void taskFour() {
		int[] i = {5,10,15,20,25}; 
		System.out.println(i[0]);
		System.out.println(i[i.length-1]);
		System.out.println(i[i.length]);
		i[5] = 10;
	}
	
	public static void taskFive() {
		int[] numbers = new int[5];
		for(int i = 0;i < numbers.length; i++ ) {
			numbers[i] = i;
		}
		System.out.print(Arrays.toString(numbers));
	}
	
	public static void taskSix() {
		int[] numbers = new int[5];
		for(int i = 0;i < numbers.length; i++ ) {
			numbers[i] = i*2;
		}
		System.out.print(Arrays.toString(numbers));
	}
	
	public static void taskSeven() {
		String[] colors = {
				"Red",
				"Blue",
				"Green",
				"Yellow",
				"Black"
		};
		for(int i = 0; i < colors.length; i++) {
			if(i == colors.length/2) {
				continue;
			}
			System.out.println(colors[i]);
		}
	}
	
	public static void taskEight() {
		String[] sweChoc = {
				"Plop",
				"Daim",
				"Marabou",
				"KEX",
				"Center"
		};
		System.out.println(Arrays.toString(sweChoc));
		
		String temp = sweChoc[0];
		sweChoc[0] = sweChoc[sweChoc.length/2];
		sweChoc[sweChoc.length/2] = temp;
		
		System.out.println(Arrays.toString(sweChoc));
	}
	
	public static void taskNine() {
		int[] numbers = {4, 2, 9, 13, 1, 0};
		
		HelperMethods.Sort(numbers);
		int large = HelperMethods.getLargeIndex(numbers);
		int small = HelperMethods.getSmallIndex(numbers);
		
		System.out.println("Array in ascending order: "+ Arrays.toString(numbers));
		System.out.println("Smallest number is " + numbers[small]);
		System.out.println("Largest number is " + numbers[large]);
		
	}
	public static void taskTen() {
		
		System.out.println("Arrays don't really support multiple data types! Unless you use an array of objects.");
		Object[] mix = new Object[5];
		mix[0] = 1;
		mix[1] = "Hello";
		mix[2] = "World";
		mix[3] = "!";
		mix[4] = 2.3;
		
		System.out.println(Arrays.toString(mix));
				
	}
	
	
}
