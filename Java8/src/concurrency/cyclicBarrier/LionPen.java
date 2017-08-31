package concurrency.cyclicBarrier;

/* We have a lion pen that needs to be emptied, cleaned and filled back with 
 * lions. There are 4 workers assigned. It is important for the workers to 
 * finish emptying the cage before cleaning it and finish cleaning it before 
 * bringing back the lions.
 * 
 * The CyclicBarrier takes in its constructors a limit value, indicating the 
 * number of threads to wait for. As each thread finishes it calls the await()
 * method of the barrier.
 * 
 * The number of available threads must be at least as large as the barrier 
 * limit or the code will hang indefinitely.
 * 
 * Like synchronization on the same object, coordinating a task with a 
 * CyclicBarrier requires the object to be static or passed to the thread
 * performing the task.
 * 
 * Once the CyclicBarrier is broken, all threads are released and the number of 
 * threads waiting goes to zero. At this point the cyclic barrier can be used 
 * 
 * */

import java.util.concurrent.*;

public class LionPen {
	
	private void removeAnimals() {
		System.out.println("Worker removing lions!");
	}
	private void cleanPen() {
		System.out.println("Worker cleaning pen!");
	}
	private void returnAnimals() {
		System.out.println("Worker returning lions to pen!");
	}
	
	public void performTask(CyclicBarrier cb1, CyclicBarrier cb2) {
		try {
			removeAnimals();
			cb1.await(); //throws both exceptions
			cleanPen();
			cb2.await();
			returnAnimals();
		} catch (InterruptedException | BrokenBarrierException e) {
			System.out.println("Exception handled!");
		}
	}
	
	public static void main(String[] args) {
		ExecutorService service =null;
		try {
			service = Executors.newFixedThreadPool(4);
			LionPen task = new LionPen();
			//the 2nd optional argument to the CyclicBarrier constructor is a 
			//Runnable that gets called upon completion
			CyclicBarrier cb1 = new CyclicBarrier(4);
			CyclicBarrier cb2 = new CyclicBarrier(4, 
						() -> System.out.println("Pen is cleaned!"));
			//now each worker performs a task involving the three steps
			for(int i = 0; i < 4; i++) { 
				service.submit( () -> task.performTask(cb1, cb2)); //Runnable 
			}
		} finally {
			if(service!=null) service.shutdown();
		}

	}

}
