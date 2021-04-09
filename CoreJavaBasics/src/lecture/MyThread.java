package lecture;

class MyThread extends Thread {

	  public void run() {

	   long timeSleep = System.currentTimeMillis() - Main.sTime;

	   System.out.printf("MyThread slept %tS s%n", timeSleep);

	 }

	}


	