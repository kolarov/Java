package functionalProgramming;

import java.util.*;

public class OptionalExample {
	
	public static Optional <Double> average (int ... scores) {
		if (scores.length == 0) {
			return Optional.empty();
		}
		int sum = 0;
		for(int score:scores)
			sum += score;
		return Optional.of((double) sum/scores.length);
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(average(90, 100));
		Optional<Double> opt = average(90, 100);
		if (opt.isPresent()) //without this we can end up with an exception
			System.out.println(opt.get());
		
		//Often we want to use empty when the value is null
		Optional o1 = Optional.ofNullable(null);
		o1.ifPresent(System.out::println);
		
		Optional<Double> o2 = average();
		o2.orElse(Double.NaN);
		o2.orElseGet(() -> Math.random());
//		o2.orElseThrow(() -> new IllegalArgumentException());
	}

}
