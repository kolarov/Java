package concurrency.forkJoin;

import java.lang.reflect.Array;

/* Fork/Join framework relies heavily on the concept of recursion to solve 
 * complex tasks. Thus always make sure that the recursive process arrives at a 
 * base case. ForkJoinTask is an abstract class  for tasks (that run within a 
 * ForkJoinPool) that is extended by RecursiveAction and RecursiveTask.  
 * 
 * RecursiveAction -> compute() method that returns void
 * RecursiveTask   -> compute() method that returns a generic type
 * 
 * 
 * Standard steps:
 * - create a ForkJoinTask (RecursiveAction or RecursiveTask. )
 * - create the ForkJoinPool
 * - start the ForkJoinTask 
 * 
 * */

/* One zoo-keeper is given the task to measure the weights of 10 animals in 1 
 * hour but but one person can only weigh 3 animals in that time. The zoo-keeper
 * asks for help another zoo-keeper and they split the task in half. Then they 
 * further subdivide until each worker has at most 3 animals to weigh. 
 * 
 * The process starts as a single task but it spawns additional concurrent tasks
 * to split up the work after it had already started. 
 * */

import java.util.*;
import java.util.concurrent.*;

public class RecursiveActionWeighAnimals extends RecursiveAction{
	private static final long serialVersionUID = 1L;
	
	private int start;
	private int end;
	private Double[] weights;
	
	public RecursiveActionWeighAnimals(Double[] weights, int start, int end) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}
	
	protected void compute() {   //Override
		//BASE CASE
		if (end - start <= 3) {
			for(int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Weighted Animal ID: " + i);
			}
		//RECURSIVE CASE
		} else {
			int middle = start + ((end - start)/2);
			System.out.println("start = " + start + ", middle = " + middle 
											+ ", end = " + end);
			invokeAll(new RecursiveActionWeighAnimals(weights, start, middle),
					  new RecursiveActionWeighAnimals(weights, middle, end));
		}
	}

	public static void main(String[] args) {
		Double[] weights = new Double[10];
		ForkJoinTask<?> task = new RecursiveActionWeighAnimals(weights, 0, 
																weights.length);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		System.out.println("Weights are: ");
		Arrays.asList(weights).stream()
							  .forEach(d->System.out.print(d.intValue() + " "));

	}

}
