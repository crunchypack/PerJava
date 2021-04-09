package com.perscholas.java_multi;

public class Priority implements Runnable {
	private static final int MAX_PRIORITY = 10;
	private static final int NORM_PRIORITY = 5;
	private static final int MIN_PRIORITY = 1;
	@Override
	public void run() {
		 
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("running thread name is: " + Thread.currentThread().getName() + "\nrunning thread priority is :" + Thread.currentThread().getPriority());
			System.out.println("========================================");
		
		
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[3];
		for(int j = 0; j < 4; j++ ) {
			for(int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new Priority(), "Thread-" + i);
				switch (i) {
				case 0:
					threads[i].setPriority(MAX_PRIORITY);
					break;
				case 1:
					threads[i].setPriority(NORM_PRIORITY);
					break;
				case 2:
					threads[i].setPriority(MIN_PRIORITY);
					break;
				}
				threads[i].start();
			}
		}
		

	}

}
