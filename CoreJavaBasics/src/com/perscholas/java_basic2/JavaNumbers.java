package com.perscholas.java_basic2;

public class JavaNumbers {

	public static void main(String[] args) {
		// Task one
		String bin1 = "1";
		String bin8 = "1000";
		String bin33 = "100001";
		String bin78 = "1001110";
		String bin787 = "1100010011";
		String bin33987 = "1000010011000011";
//		binToDec(bin1);
//		binToDec(bin8);
//		binToDec(bin33);
//		binToDec(bin78);
//		binToDec(bin787);
//		binToDec(bin33987);
		// Task two
		 int dec10 = 2;
		 int dec1001 = 9;
		 int dec110100 = 52;
		 int dec1110010 = 114;
		 int dec1000011111 = 1087;
		 int dec10110001100111 = 11367;
//		 decToBin(dec10);
//		 decToBin(dec1001);
//		 decToBin(dec110100);
//		 decToBin(dec1110010);
//		 decToBin(dec1000011111);
//		 decToBin(dec10110001100111); 
		 
		 taskEigth();
		

	}
	public static void binToDec (String bin) {
		int decimal = Integer.parseInt(bin,2);
		System.out.println(decimal);
	}
	public static void decToBin (int num) {
		String binary = Integer.toBinaryString(num);
		System.out.println(binary);
	}
	public static void taskThree() {
		int x = 2;
		System.out.println(Integer.toBinaryString(x));
		x = x << 1;
		// 4
		// Since 2 is 10 shifting to the left gives us 100 which is 4
		System.out.println("Decimal: "+ x);
		System.out.println("Binary: " +Integer.toBinaryString(x));
		
		int y = 9;
		System.out.println(Integer.toBinaryString(y));
		y = y << 1;
		// We think it will be 18
		// from 1001 to 10010
		System.out.println("Decimal: "+ y);
		System.out.println("Binary: " +Integer.toBinaryString(y));
		
		int z = 17;
		System.out.println(Integer.toBinaryString(y));
		z = z << 1;
		// 34
		// from 10001 to 100010
		System.out.println("Decimal: "+ z);
		System.out.println("Binary: " +Integer.toBinaryString(z));
		
		int q = 88;
		System.out.println(Integer.toBinaryString(y));
		q = q << 1;
		// 176
		// TO LONG, but dude trust me.
		System.out.println("Decimal: "+ q );
		System.out.println("Binary: " +Integer.toBinaryString(q));
	}
	public static void taskFour() {
		int x = 150;
		System.out.println(Integer.toBinaryString(x));
		
		x = x >> 2;
		// 37
		// 10010110 to 100101 --Almost forgot we are shifting be 2 and not one
		System.out.println("Decimal: "+ x);
		System.out.println("Binary: " +Integer.toBinaryString(x));
		
		
		int y = 1555;
		System.out.println(Integer.toBinaryString(x));
		
		y = y >> 2;
		// 388
		// Dude trust me.
		System.out.println("Decimal: "+ y);
		System.out.println("Binary: " +Integer.toBinaryString(y));
		
		
		int z = 32456;
		System.out.println(Integer.toBinaryString(x));
		
		z = z >> 2;
		// 8114
		// ....
		System.out.println("Decimal: "+ z);
		System.out.println("Binary: " +Integer.toBinaryString(z));
	}
	
	public static void taskFive() { 
		int x =7, y = 17;
		int z;
		// The result will be 1 
		z = x & y;
		System.out.println(z);
		System.out.println(Integer.toBinaryString(z));
		// For the OR operation the result will be 23
		z = x | y;
		System.out.println(z);
		System.out.println(Integer.toBinaryString(z));
		
	}
	public static void taskSix() {
		int a = 8;
		System.out.println(a++);
		System.out.println(a);
	}
	public static void taskSeven() {
		int a = 8;
		System.out.println(a++);
		System.out.println(a);
		++a;
		System.out.println(a);
		
	}
	public static void taskEigth() {
		int x,y;
		x = 5;
		y = 8;
		// Calculation -- Notice difference between ++x and x++
		int sum = x++ + y;
		System.out.println(sum);
		
	}
}
