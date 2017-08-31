package functionalProgramming.primitiveStreams;

import java.util.stream.*;
import java.util.*;


/* Regular streams work with Objects. If we need primitives instead of the 
 * corresponding wrapper class, we need to use primitive streams:
 * 
 * InrStream: int, short, byte, char
 * LongStream: long
 * DoubleStream: double, float
 * 
 * We also need other types of Optionals for the result of the pipeline.
 * */
public class Examples {
	
	//we need this since we can't run two terminal operations on the same stream
	private static int range ( IntStream ints) {
		IntSummaryStatistics stats = ints.summaryStatistics();
		if (stats.getCount() == 0 )
			throw new RuntimeException();
		return stats.getMax()-stats.getMin();
	}
	
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3);
		System.out.println(stream.mapToInt(x -> x).sum());
		
		IntStream intStream1 = IntStream.of(1,2,3);
		OptionalDouble avg = intStream1.average();  //average() -> OptionalDouble
		System.out.println(avg.getAsDouble());
		
		DoubleStream random = DoubleStream.generate(Math::random);
		DoubleStream fractions = DoubleStream.iterate(0.5, d -> d/2);
		random.limit(3).forEach(System.out::println);
		fractions.limit(3).forEach(System.out::println);
		
		IntStream range = IntStream.range(1, 6);
		range.forEach(System.out::println);
		IntStream rangeClosed = IntStream.rangeClosed(1, 5);
		rangeClosed.forEach(System.out::println);
		
		/*mapToObj		- create a Stream from another Stream
		 *mapToDouble 	- create a DoubleStream from another type of stream
		 *mapToInt 		- create a IntStream from another type of stream
		 *mapToLong 	- create a LongStream from another type of stream
		 *map 			- map to the same type of stream
		 * 
		 * */
		Stream<String> objStream = Stream.of("penguin", "fish");
		IntStream intStream2 = objStream.mapToInt(s -> s.length());
		System.out.println(range(intStream2)); //3
		
	}

}
