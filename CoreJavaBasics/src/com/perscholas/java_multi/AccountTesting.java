package com.perscholas.java_multi;

public class AccountTesting implements Runnable{
	protected Account a = new Account();
	@Override
	public void run() {
		int bal = a.getBalance();
		
		while(true) {
			
			if(bal > 10) {
				System.out.println(Thread.currentThread().getName() + " is going to withdraw");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				a.withdrawal(10);
				System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
			}
			else {
				System.out.println("Not enough money in the account for " + Thread.currentThread().getName() + " to withdraw");
				break;
				
			}
			bal = a.getBalance();
			
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new AccountTesting(), "Reema");
		Thread t2 = new Thread(new AccountTesting(), "Ranjeet");
		
		t1.start();
		t2.start();
		
		
		
		
	}

}
