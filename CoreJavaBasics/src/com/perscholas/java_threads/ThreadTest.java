package com.perscholas.java_threads;


public class ThreadTest extends Thread{
	public ThreadTest(String name) {
		super(name);
	}
	@Override
	public void run() {
		System.out.println("Hello World! From thread nr: " + Thread.currentThread().getId());
	}

	public static void main(String[] args) {
		ThreadTest[] threads = new ThreadTest[5];
		for(int i = 0; i < threads.length; i ++) {
			threads[i] = new ThreadTest("Coolthread " + i);
			threads[i].start();
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
