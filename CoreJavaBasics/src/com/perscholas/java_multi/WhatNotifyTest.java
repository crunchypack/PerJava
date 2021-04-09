package com.perscholas.java_multi;

public class WhatNotifyTest {

	public static void main (String[] args) {
		Message msg = new Message("process it");
		
		Waiter waiter1 = new Waiter(msg);
		Waiter waiter2 = new Waiter(msg);
		Notifier notifier = new Notifier(msg);
		
		Thread t1 = new Thread(waiter1, "waiter1");
		Thread t2 = new Thread(waiter2, "waiter2");
		Thread t3 = new Thread(notifier, "notifier");
		
		t1.start();		
		
		t2.start();		
		
		t3.start();
		
		System.out.println("All threads are started");
	}

}
