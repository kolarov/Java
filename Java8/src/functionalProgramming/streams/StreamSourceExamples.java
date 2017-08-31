package functionalProgramming.streams;

import java.util.stream.*;
import java.util.*;

public class StreamSourceExamples {

	public static void main(String[] args) {
		//we can use a stream only ONCE!
		Stream<String> empty = Stream.empty();
		Stream<Integer> single = Stream.of(1);
		Stream<Integer> fromArray = Stream.of(1,2,3);
		
		List<String> list = Arrays.asList("a","b","c");
		Stream<String> fromList = list.stream();
		Stream<String> fromListParallel = list.parallelStream();
		// the streams do not start until we provide a terminal operation
		Stream<Double> random = Stream.generate(Math::random);
		Stream<Integer> addNums = Stream.iterate(1, n -> n+2);
		System.out.println(addNums); //just a reference to a stream object
	}

}
