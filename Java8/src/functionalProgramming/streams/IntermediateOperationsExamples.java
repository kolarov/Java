package functionalProgramming.streams;

import java.util.stream.*;
import java.util.*;

/* Intermediate Operations are:
 * 
 * Stream<T> 		filter	(Predicate<? super T> predicate)
 * Stream<T> 		distinct()
 * Stream<T> 		limit	(long maxSize)
 * Stream<T> 		skip	(long n)
 * <R> Stream<R> 	map		(Function<? super T, ? extends R> mapper)
 * <R> Stream<R> 	flatMap	(Function<? super T, ? extends Stream<? extends R>> 
 * 																		mapper)
 * Stream<T> 		sorted	()
 * Stream<T> 		sorted	(Comparator<? super T> comparator)
 * Stream<T> 		peek	(Consumer<? super T> action)
 * 
 * */

public class IntermediateOperationsExamples {

	public static void main(String[] args) {
		
		//filter()
		Stream<String> s1 = Stream.of("monkey", "gorilla", "bonobo");
		s1.filter(x -> x.startsWith("m")).forEach(System.out::println);
		
		//distinct()
		Stream<String> s2 = Stream.of("duck", "duck", "goose");
		s2.distinct().forEach(System.out::println);
		
		//limit() and skip()
		Stream<Integer> s3 = Stream.iterate(1, n -> n+1);
		s3.skip(5).limit(2).forEach(System.out::println);
		
		//map()
		Stream<String> s4 = Stream.of("monkey", "gorilla", "bonobo");
		s4.map(String::length).forEach(System.out::print);
		
		//flatMap()
		List<String> zero = Arrays.asList("\n");
		List<String> one = Arrays.asList("bonobo ");
		List<String> two = Arrays.asList("mamma gorilla ", "baby gorilla");
		Stream<List<String>> animals = Stream.of(zero,one,two);
		animals.flatMap(l -> l.stream()).forEach(System.out::print);
		
		//sorted()
		Stream<String> s5 = Stream.of("monkey", "gorilla", "bonobo");
		s5.sorted().forEach(System.out::println);
		Stream<String> s6 = Stream.of("monkey", "gorilla", "bonobo");
		s6.sorted(Comparator.reverseOrder()).forEach(System.out::println);
		//s6.sorted(Comparator::reverseOrder); //will not compile !!!
		
		//peek()
		Stream<String> s7 = Stream.of("black bear", "brown bear", "grizzly");
		long count = s7.filter(s->s.startsWith("b"))
					   .peek(System.out::println)
					   .count(); //2
		StringBuilder builder = new StringBuilder();
		Stream<List<?>> good = Stream.of(Arrays.asList(1), Arrays.asList("a"));
		good.peek(l -> builder.append(l))
			.map(List::size)
			.forEach(System.out::println); //11
		System.out.println(builder);
		
		// Pipeline: given a list of names, get the first two names 
		// alphabetically that have 4 chars
		List<String> list = Arrays.asList("Toby", "Ann", "Leroy", "Alex");
		list.stream().filter(n -> n.length()==4)
					 .sorted()
					 .limit(2)
					 .forEach(System.out::println); //Alex Toby
		Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
		infinite.limit(5)
				.peek(System.out::print)
				.filter(x -> x%2==1)
				.forEach(System.out::print);
		//if we swap filter() and limit() the code will hang until we kill the
		//whole program
		
	}

}
