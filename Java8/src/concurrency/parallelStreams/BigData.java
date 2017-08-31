package concurrency.parallelStreams;

/* A parallel stream is a stream that is capable of processing results
 * concurrently using multiple threads. 
 * We can get a parallel stream by either:
 * - call .parallel() on an existing stream
 * - call .parallelStream() on a Collection
 * 
 * The stream interface includes a method isParallel() that can be used to test
 * if the instance of a stream supports parallel processing.
 * 
 * 
 * 
 * Parallel streams tend to achieve the most improvement when the number of 
 * elements in the stream is significantly large. Sometimes using parallel 
 * streams can slow the application.
 * 
 * 
 * 
 * 
 * */

import java.util.*;

public class BigData {
	
	public int processRecord(int input) {
		try{
			Thread.sleep(10);
		}
		catch (InterruptedException e) {
			System.out.println("InterruptedException caught!");
		}
		return input + 1;
	}
	
	public void processAllDataSlow(List<Integer> data) {
		data.stream()
			.map(a -> processRecord(a))
			.count();
	}
	
	public void processAllDataFast(List<Integer> data) {
		data.parallelStream()
			.map(a -> processRecord(a))
			.count();
	}
	
	
	public static void main(String[] args) {
		
		//First a couple simple examples
		Arrays.asList(1,2,3,4,5,6,7,8,9) 					//no order
				.parallelStream()
				.forEach(s -> System.out.println(s + " "));		
		Arrays.asList(1,2,3,4,5,6,7,8,9) 					//preserves order
				.parallelStream()	
				.forEachOrdered(s -> System.out.println(s + " "));
		
		
		BigData calculator = new BigData();
		List<Integer> data = new ArrayList<>();
		for (int i = 0; i < 4000; i++) 
			data.add(i);
		
		long start1 = System.currentTimeMillis();
		calculator.processAllDataSlow(data);
		double time1 = (System.currentTimeMillis() - start1)/1000.0;
		System.out.println("Sequential task completed in: "+time1+" seconds!");
		
		long start2 = System.currentTimeMillis();
		calculator.processAllDataFast(data);
		double time2 = (System.currentTimeMillis() - start2)/1000.0;
		System.out.println("\nParallel task completed in: "+time2+" seconds!");
	}

}
