package concurrency.executorService.singleThreadExecutor;

import java.io.IOException;

/* The return type of the execute() method is void and thus does not tell us 
 * anything about the result of the task. The submit() method is similar to
 * execute() but it returns is a Future object that can be used to determine if 
 * the task is complete.           
 * - Future<?> 				submit(Runnable task)
 * - <T> Future<T> 			submit(Callable<T> task)
 * Callable is very similar to Supplier but Callable can throw a checked 
 * exception. However, lambdas can't always make the difference!
 * 
 * java.lang.Runnable is a @Functional Interface
 * public interface Runnable {
 * 		void run();
 * }
 * java.util.concurrent.Callable is a @Functional Interface
 * public interface Callable<V> {
 * 	 	V run() throws Exception;
 * }
 * 
 * Future Methods:
 * - boolean isDone()  returns true if task is completed; exception of cancelled
 * - boolean isCancelled() returns true if task was cancelled before completion
 * - boolean cancel(boolean maiInterrupt) attempts to cancel execution 
 * - V get() returns the result of a task, waiting endlessly if not available
 * - V get(long timeout, TimeUnit unit) returns the result of a task, waiting 
 * 										the specified amount of time. If not 
 * 										ready, a checked TimeoutException 
 * */
import java.util.function.*;
import java.util.concurrent.*;

class AmbiguousLambdaExample {
	public static void useCallable(Callable<Integer> expression) {}
	public static void useSupplier(Supplier<Integer> expression) {}
	public static void use(Supplier<Integer> expression) {};
	public static void use(Callable<Integer> expression) {};
}


public class Submit {
	
	private static int counter = 0;
	
	public static void main(String[] args) throws InterruptedException,
									ExecutionException {
		
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			//_____Submit Runnable_____
			Future<?> result1 = service.submit( 					
					() -> {for (int i = 0; i < 500; i++) Submit.counter++;} );
	//As Future<?> is a generic class, ? is determined by the return type of the 
	//Runnable method. Since run() returns void -> get() always returns null
			result1.get(200, TimeUnit.MICROSECONDS); //returns null
			System.out.println("Reached!");

			//_____Submit Callable_____
			Future<Integer> result2 = service.submit(() -> 30 + 11); 
			System.out.println(result2.get());
	//Thread.sleep() throws InterruptedException -> use Callable
			service.submit(() -> {Thread.sleep(1000); return null;});//OK
			//however the following is a Runnable and does not compile
			//service.submit(() -> {Thread.sleep(1000);});
			
		} catch (TimeoutException e) { //can be thrown from get() 
			System.out.println("Not reached in time!");
		} finally {
			if (service != null) service.shutdown();
		}
		if (service != null) {
	//the awaitTermination() method waits the specified time but returns sooner
	//if all tasks are finished or if we get an InterruptedException
			service.awaitTermination(1, TimeUnit.MICROSECONDS);
			if(service.isTerminated())
				System.out.println("All tasks finished!");
			else 
				System.out.println("Atleast one task is still running");
		}
		
		
		//_____Ambiguous Lambda Example_____
		AmbiguousLambdaExample.useCallable(() -> {throw new IOException();});
		AmbiguousLambdaExample.use(
				(Callable<Integer>)() -> {throw new IOException();});
		//but the following two do not compile
		//AmbiguousLambdaExample.useSupplier(() -> {throw new IOException();});
		//AmbiguousLambdaExample.use(() -> {throw new IOException();});
		
	}
}
