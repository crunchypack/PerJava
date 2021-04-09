package com.perscholas.java_multi;



public class SleepJoin implements Runnable{

	public static void main(String[] args) {
		Thread[] threads = new Thread[3];
		threads[0] = new Thread(new SleepJoin(),"My First Thread");
		threads[1] = new Thread(new SleepJoin(),"My Second Thread");
		threads[2] = new Thread(new SleepJoin(),"My Thirds Thread");
		
		threads[0].start();
		try {
			threads[0].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1; i < threads.length; i++) {
			threads[i].start();
		}

	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+ "," + Thread.currentThread().getPriority() + "," + Thread.currentThread().getThreadGroup().getName());
		for(int i = 1; i <= 5; i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
	}

}
