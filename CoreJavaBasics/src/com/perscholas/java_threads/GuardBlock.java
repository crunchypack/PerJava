package com.perscholas.java_threads;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GuardBlock implements Runnable{
	public static final Queue queue = new ConcurrentLinkedQueue();
	public static int i = 0;
	   public synchronized void run() {
	     
	       while(i < 1000000) {
	           i++;
	       }
	       synchronized (queue) {
	    	   queue.notifyAll();
		}
	         
	        
	     
	   }
	   static class Display implements Runnable {
	       public synchronized void run() {
	    	   synchronized(queue) { 
	    		   try {
	    			   queue.wait();
	    			   } catch (InterruptedException e) {
	    				   e.printStackTrace();
	    				   }
	    		   }
	    	   System.out.println(i);
	         
	       }      
	   }
	    public static void main(String[] args) throws InterruptedException {
	       GuardBlock gb = new GuardBlock();
	       Display d = new Display();
	       Thread gThread = new Thread(gb);
	       Thread dThread = new Thread(d);
	       gThread.start();
	       dThread.start();
	      
	       

	    }
}