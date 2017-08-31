package concurrency.executorService.singleThreadExecutor;

/* With a single-thread executor the results are guaranteed to be executed 
 * in the order in which they are added to the executor service.
 * 
 * Executor Methods:
 * - void 					execute(Runnable command) 
 * - Future<?> 				submit(Runnable task)
 * - <T> Future<T> 			submit(Callable<T> task)
 * - <T> List<Future<T>> 	invokeAll(Collection<? extends Callable<T>> task)
 * 													throws InterruptedException 
 * - <T> T 					invokeAny(Collection<? extends Callable<T>> task)
 * 								throws InterruptedException, ExecutionException 
 * invokeAll() and invokeAny() both take a Collection of tasks to execute. Both 
 * execute synchronously, meaning that unlike the other three methods these will
 * wait until the results are available and only then return control to the 
 * enclosing program.
 * 
 * */ 

import java.util.concurrent.*;

public class Execute {
	
	public static void main(String[] args) {
		
		ExecutorService service = null;
		try {
			//Executors is a factory class
			service = Executors.newSingleThreadExecutor();
			System.out.println("Beginning"); //thread 1 (main)
			
			//the next three tasks are executed by thread 2 (service)
			service.execute(() -> System.out.println("Checkin the inventory!"));
			service.execute(() -> {	for (int i = 0; i < 3; i++)
										System.out.println("Record: " + (i+1));
								  });
			service.execute(() -> System.out.println("Checkin the inventory!"));
			
			System.out.println("Ending"); //thread 1 (main)
			
		} finally {
			//Without this the program cannot terminate because of a non-daemon 
			//thread. We cannot use try-with-resources!
			if (service != null) service.shutdown();
			//alternatively shutdownNow() attempts to stop all running tasks
		}
	}
}
