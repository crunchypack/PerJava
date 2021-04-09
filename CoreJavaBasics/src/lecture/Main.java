package lecture;

public class Main {

	/*precise moment when the program starts running*/

	static long sTime = System.currentTimeMillis();

	 

	  public static void main(String[] args)

	                                   throws InterruptedException {

	 

	    MyThread mt = new MyThread();

	    MyThread.sleep(2000);

	    mt.start();

	 

	    long timeSleep = System.currentTimeMillis() - Main.sTime;

	    System.out.printf("Main slept %tS s%n", timeSleep);

	  }
	  }