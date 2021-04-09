package com.perscholas.java_functional2;

public class MyCalc<T> {
	Calculator<Integer> sum = (x, y) ->(x+y);
	Calculator<Integer> substract = (x, y) ->(x-y);
	Calculator<Float> multiply = (x, y) ->(x*y);
	Calculator<Float> divide = (x, y) ->(x/y);
	
		
}