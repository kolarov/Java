package concurrency.executorService.atomicAndThreadPools;

/* The Executors class has three additional factory methods that act on a pool
 * of threads. They return ExecutorService or a ScheduledExecutorService.
 * 
 * - newCachedThreadPool(): Creates new threads as needed. Commonly used to 
 * 						execute many short-lived asynchronous tasks. Strongly
 * 						discouraged for long-lived processes.
 * - newFixedThreadPool(int n): reuses a fixed number of threads operating off 
 * 						a shared unbounded queue
 * - newScheduledThreadPool(int n): identical to newFixedThreadPool() but it 
 * 						returns a ScheduledExecutorService and thus compatible 
 * 						with scheduling tasks.
 * */

/* classes that support atomic operations+
 * 		AtimicBoolean
 * 		AtimicInteger
 * 		AtimicLong
 * 		AtimicReference
 * 		AtimicIntegerArray
 * 		AtimicLongArray
 * 		AtimicReferenceArray
 * 
 * Comon atomic methods:
 * - get()
 * - set()
 * - getAndSet()
 * - incrementAndGet()
 * - getAndIncrement()
 * - decrementAndGet()
 * - getAndDecrement()
 * 
 * The ++ operator for example is not thread-safe because it is not atomic
 * 
 * */

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class AtomicSample {
	
	private int count1 = 0;
	private AtomicInteger  count2 = new AtomicInteger(0);
	
	private void incrementNonAtomic() {
		System.out.println((++count1) + " ");
	}
	private void incrementAtomic() {
		System.out.println( count2.incrementAndGet() + " ");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		AtomicSample counter = new AtomicSample();
		ExecutorService service = null;
		//this can lead to possible repetition since ++ is not thread-safe 
		try {
			service = Executors.newFixedThreadPool(20);
			for (int i = 0; i < 10; i++) { 
				service.submit(() -> counter.incrementNonAtomic());
			}
		} finally {
			if (service != null) service.shutdown();
		}
		if (service != null) { 				 //waiting for all tasks to finish
			service.awaitTermination(1, TimeUnit.SECONDS);
			if(service.isTerminated())
				System.out.println("All tasks finished!");
			else 
				System.out.println("Atleast one task is still running");
		}
		
		//this ensures that there are no repetitions since incrementAndGet() 
		//is thread-safe 
		try {
			service = Executors.newFixedThreadPool(20);
			for (int i = 0; i < 10; i++) {
				service.submit(() -> counter.incrementAtomic());
			}
		} finally {
			if (service != null) service.shutdown();
		}
		

	}

}
