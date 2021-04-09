package com.perscholas.java_threads;

public class SimpleSync implements Runnable{
	private static int count = 0;
	public synchronized void run() {
		while(count < 1000000) {
			
				count++;
			
			
		}
		System.out.println(count);
	}
	

	public static void main(String[] args) {
		Thread[] threads = new Thread[2];
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new SimpleSync(),"Thread-" + i);
			threads[i].start();
		}

	}

}
