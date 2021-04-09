package com.perscholas.java_multi;

public class Notifier extends Thread{
	private Message msg;

	public Notifier(Message msg) {
		this.msg = msg;
	}
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " started");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(msg) {
			msg.setMessage(name + " Notifier work done");
			msg.notifyAll();
		}
	}
}
