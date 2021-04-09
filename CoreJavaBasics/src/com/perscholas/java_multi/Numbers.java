package com.perscholas.java_multi;


public class Numbers implements Runnable{
	@Override
	public void run() {
		for(int i = 1; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[2];
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Numbers());
			threads[i].start();
		}

	}

	

}
