package concurrency.synchronizing;

/* We can improve our AtomicSample.java example by making sure the results are 
 * ordered. For that we need a monitor (or lock) that supports mutual exclusion.
 * In Java any object can be used as a monitor, along with the synchronized 
 * keyword.
 * 
 * Synchronization, while useful, may be costly in practice. It is about 
 * protecting data integrity at the price of performance.
 * 
 * */

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class SynchronizationSample {
	
	//We do not need to use an atomic variable since synchronization allows only
	//one thread to enter!!!
	private static int count = 0;
	
	//use the particular instance as a lock with the method modifier
	private synchronized void incrementAndReport1() {
		System.out.println( ++count + " ");
	}
	
	//same as
	private void incrementAndReport2() {
		//synchronization block
		synchronized (this) {     
			System.out.println( ++count + " ");
		}
	}
	
	//we can use synchronize on any object as long as it is the same
	//the final modifier prevent the lock from changing after the thread starts
	private final Object lock = new Object(); 
	private void incrementAndReport3() {
		//synchronization block
		synchronized (lock) {     
			System.out.println( ++count + " ");
		}
	}
	
	//can be used for static methods but we must synchronize on the class
	private static void incrementAndReport4() {
		//synchronization block
		synchronized (SynchronizationSample.class) {     
			System.out.println( ++count + " ");
		}
	}	
	
	public static void main(String[] args) throws InterruptedException {
		
		SynchronizationSample counter = new SynchronizationSample();
		ExecutorService service = null;
		
		//_____METHOD1_____
		try {
			service = Executors.newFixedThreadPool(20);
			for (int i = 0; i < 10; i++) {
				service.submit(() -> counter.incrementAndReport1());
			}
		} finally {
			if (service != null) service.shutdown();
		}
		if (service != null) {
			service.awaitTermination(1, TimeUnit.SECONDS);
			if(service.isTerminated())
				System.out.println("All tasks finished!");
			else 
				System.out.println("Atleast one task is still running");
		}
		
		//_____METHOD2_____
		try {
			service = Executors.newFixedThreadPool(20);
			for (int i = 0; i < 10; i++) {
				service.submit(() -> counter.incrementAndReport2());
			}
		} finally {
			if (service != null) service.shutdown();
		}
		if (service != null) {
			service.awaitTermination(1, TimeUnit.SECONDS);
			if(service.isTerminated())
				System.out.println("All tasks finished!");
			else 
				System.out.println("Atleast one task is still running");
		}
		
		//_____METHOD3_____
		try {
			service = Executors.newFixedThreadPool(20);
			for (int i = 0; i < 10; i++) {
				service.submit(() -> counter.incrementAndReport3());
			}
		} finally {
			if (service != null) service.shutdown();
		}
		if (service != null) {
			service.awaitTermination(1, TimeUnit.SECONDS);
			if(service.isTerminated())
				System.out.println("All tasks finished!");
			else 
				System.out.println("Atleast one task is still running");
		}
		
		//_____METHOD4_____
		try {
			service = Executors.newFixedThreadPool(20);
			for (int i = 0; i < 10; i++) {
				service.submit(() -> counter.incrementAndReport4());
			}
		} finally {
			if (service != null) service.shutdown();
		}

	}

}
