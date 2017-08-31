package concurrency.runnableAndThread;
/* 
 * Alternatively you can use the ExecutorService to perform thread tasks without
 * having to create Thread objects directly
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
 * 
 * Defining a task that a Thread will execute can be done in two ways:
 * - provide a Runnable object or lambda expression to the Thread constructor 
 * - create a class that extends Thread and overrides the run() method
 * 
 * Java does not provide any guarantees about the order in which a thread will 
 * be processed once it is started.
 * 
 * */


class PrintData implements Runnable {
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Printing record: " + (i+1));
		}
	}
}

class CheckInventory extends Thread { // this is used only in specific cases
	public void run () {
		System.out.println("Checking the inventory!");
	}
}

public class RunnableVsThread {
	public static void main(String[] args) {
		// starting the tasks in separates threads in the operating system
		(new Thread( new PrintData())).start();
		(new CheckInventory()).start();
		
		// or we can execute the tasks sequentially in the same thread
		(new Thread( new PrintData())).run();
		(new CheckInventory()).run();
		
	}
}
