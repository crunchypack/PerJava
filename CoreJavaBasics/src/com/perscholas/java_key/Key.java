package com.perscholas.java_key;

import java.util.UUID;

public class Key implements Cloneable,Comparable<Key>{
	private UUID key;
	private KeyShape shape = KeyShape.Unknown;

	public Key() {
		key = UUID.randomUUID();
	}
	public Key(KeyShape shape) {
		this();
		this.shape = shape;
	}
	public Key (Key og) {
		key = og.key;
		shape = og.shape;
	}
	public KeyShape shape() {
		return shape;
	}
	@Override
	public String toString() {
		return key.toString();
	}
	@Override
	public Object clone() {
		return new Key(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!getClass().isInstance(obj)) {
			return false;
		}
		Key other = (Key) obj;
		return key.equals(other.key);
	}
	@Override
	public int hashCode() {
		return key.hashCode();
	}
	@Override
	public int compareTo(Key o) {
		
		return key.compareTo(o.key);
	}

}
