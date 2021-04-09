package com.perscholas.java_functional2;
@FunctionalInterface
public interface Calculator<T> {
	public T compute(T x, T y );

}
