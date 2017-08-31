package functionalProgramming;

import java.util.*;
import java.util.TreeSet;
import java.util.stream.*;




public class CollectorsExamples {

	public static void main(String[] args) {
		
		//Collectors.joining()
		Stream<String> ohMy1 = Stream.of("lion", "tigers", "bears");
		String result1 = ohMy1.collect(Collectors.joining(", "));
		System.out.println(result1);
		
		//Collectors.averagingInt()
		Stream<String> ohMy2 = Stream.of("lion", "tigers", "bears");
		Double result2 = ohMy2.collect(Collectors.averagingInt(String::length));
		System.out.println(result2);
		
		//Collectors.toCollection()
		Stream<String> ohMy3 = Stream.of("lion", "tigers", "bears");
		TreeSet<String> result3 = ohMy3.filter(s -> s.startsWith("t"))
								.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(result3);
		
		//Collectors.toMap()
		Stream<String> ohMy4 = Stream.of("lion", "tigers", "bears");
		Map<String,Integer> result4 = ohMy4.collect(
									Collectors.toMap(s -> s, String::length));
		System.out.println(result4);
		
		//Collectors.groupingBy()
		Stream<String> ohMy5 = Stream.of("lion", "tigers", "bears");
		Map<Integer, List<String>> result5 = ohMy5.collect(
										Collectors.groupingBy(String::length));
		System.out.println(result5);
		
		Stream<String> ohMy51 = Stream.of("lion", "tigers", "bears");
		Map<Integer, Long> result51 = ohMy51.collect(
				Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(result51);
		
		//Collectors.partitioningBy()
		Stream<String> ohMy6 = Stream.of("lion", "tigers", "bears");
		Map<Boolean,List<String>> result6 = ohMy6.collect(
							Collectors.partitioningBy(s -> s.length() <= 5));
		System.out.println(result6);
			
		
		
	}

}
