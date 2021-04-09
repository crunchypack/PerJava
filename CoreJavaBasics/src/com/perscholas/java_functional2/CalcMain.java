package com.perscholas.java_functional2;

import java.util.Scanner;

public class CalcMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyCalc<Object> calc = new MyCalc<>();
		StringBuffer res = new StringBuffer();
		System.out.print("Enter expression (x+y): ");
		
		
		String[] exp = sc.nextLine().split("(?<=[-+*/])|(?=[-+*/])");
		String op = exp[1];
		switch(op) {
		case "+":
			int x = Integer.parseInt(exp[0].trim());
			int y = Integer.parseInt(exp[2].trim());
			int z = calc.sum.compute(x, y);
			res.append(x + op + y + "=" + z);
			System.out.println(res);
			break;
		case "-":
			int a = Integer.parseInt(exp[0].trim());
			int b = Integer.parseInt(exp[2].trim());
			int c = calc.substract.compute(a, b);
			res.append(a + op + b + "=" + c);
			System.out.println(res);
			break;
		case "*":
			float m1 = Float.parseFloat(exp[0].trim());
			float m2 = Float.parseFloat(exp[2].trim());
			float m3 = calc.multiply.compute(m1, m2);
			res.append(m1 + op + m2 + "=" + m3);
			System.out.println(res);
			break;
		case "/":
			float d1 = Float.parseFloat(exp[0].trim());
			float d2 = Float.parseFloat(exp[2].trim());
			float d3 = calc.divide.compute(d1, d2);
			res.append(d1 + op + d2 + "=" + d3);
			System.out.println(res);
			break;
		default:
			System.out.println("Use real operators!");
		}
		sc.close();
		

	}

}
