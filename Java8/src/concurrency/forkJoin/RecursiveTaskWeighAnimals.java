package concurrency.forkJoin;

import java.util.*;
import java.util.concurrent.*;


/* This time we want to compute the sum of all weigh values while processing the
 * data -> use RecursiveTask. Since the invokeAll() method doesn't return a 
 * value, we instead issue a fork() and join() command to retrieve the recursive 
 * data. The fork() instructs the framework to complete the task in a separate
 * thread , while the join() causes the current thread to wait for the results.
 * 
 * Make sure that fork() is called before the current thread begins a subtask
 * and join() is called after it finishes retrieving the results, in order for 
 * them to be done in parallel.
 * 
 * Overview:
 * - the class should extend RecursiveAction or RecursiveTask 
 * - if it extends RecursiveAction -> override protected void compute()
 * - if it extends RecursiveTask -> override protected T compute() where T is 
 * 	 specified in the class definition
 * - invokeAll() method takes two instances of the fork/join class and does not
 * 	 return a result
 * - fork() causes a new task to be submitted to the pool
 * - join() is called after a fork and causes the current thread to wait for the 
 * 	 results of the subtask
 * - calling compute() within a compute(), unlike calling a fork() within a 
 *   compute(), causes the task to wait for the result of the subtask
 * - the fork() method should be called before the current thread performs a 
 * 	 compute() operation, with join() called to read the result afterwards.
 * 
 * 
 * */

public class RecursiveTaskWeighAnimals extends RecursiveTask<Double> {
	
	private int start;
	private int end;
	private Double[] weights;
	
	public RecursiveTaskWeighAnimals(Double[] weights, int start, int end) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}
	
	protected Double compute() {
		//BASE CASE
		if (end - start <= 3) {
			double sum = 0;
			for(int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Weighted Animal ID: " + i);
				sum += weights[i];
			}
			return sum;
		//RECURSIVE CASE
		} else {
			int middle = start + ((end - start)/2);
			System.out.println("s = "+ start +", m = "+ middle +", e = "+ end);
			RecursiveTask<Double> task = new RecursiveTaskWeighAnimals(weights, 
																start, middle);
		//task.fork().join() will make the current thread to wait for the 
		//start-middle subtask (task) to finish before starting the 
		//middle-end subtask, thus leading to single-threaded behavior
			task.fork();
			return new RecursiveTaskWeighAnimals(weights, middle, end).compute()
					+ task.join();
		}
		 
	}
	
	
	public static void main(String[] args) {
		Double[] weights = new Double[10];
		ForkJoinTask<Double> task = new RecursiveTaskWeighAnimals(weights, 0, 
																weights.length);
		ForkJoinPool pool = new ForkJoinPool();
		Double sum = pool.invoke(task);
		System.out.println("Sum: " + sum);
		Arrays.asList(weights).stream()
							  .forEach(d->System.out.print(d.intValue() + " "));
	}

}
