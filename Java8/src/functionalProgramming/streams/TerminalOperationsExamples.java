package functionalProgramming.streams;

import java.util.stream.*;
import java.util.*;
import java.util.function.*;


/* Terminal Operations are:
 * 
 * ___Reductions___:
 * long  		count()
 * Optional<T> 	min(Comparator<? super T> comparator)
 * Optional<T> 	max(Comparator<? super T> comparator)
 * <R,A>  R		collect(Collector<? super T,A,R> collector)
 * T			reduce(T identity, BinaryOperator<T> accumulator)
 * Optional<T>	reduce(BinaryOperator<T> accumulator) 
 * 		//for processing collections in parallel: 
 * <R> 	R		collect(Supplier<R> supplier, BiConsumer<R, ? super T> 
 * 										accumulator, BiConsumer<R, R> combiner) 
 * <U>	U		reduce(U identity, BiFunction<U, ? super T,U> accumulator, 
 * 													BinaryOperator<U> combiner)  
 * without an identity we have to return an Optional in case the stream is empty
 * 
 * ___Others___:
 * boolean 		allMatch(Predicate<? super T> predicate)
 * boolean 		anyMatch(Predicate<? super T> predicate)
 * boolean 		noneMatch(Predicate<? super T> predicate)
 * Optional<T>	findAny()
 * Optional<T>  findFirst()
 * void			forEach(Consumer<? super T> action)
 * */
public class TerminalOperationsExamples {

	public static void main(String[] args) {
		//count
		Stream<String> s1 = Stream.of("monkey", "gorilla", "bonobo");
		System.out.println(s1.count());

		//min() and max()
		Stream<String> s2 = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = s2.min((str1,str2)->str1.length()-str2.length()); 
		min.ifPresent(System.out::println);
		Optional<?> minEmpty = Stream.empty().min((a,b) -> 0);
		minEmpty.isPresent(); //false
		
		//reduce()
		Stream<String> stream = Stream.of("w", "o", "l", "f");
		String word = stream.reduce("", (s,c) -> s+c); //or ("",String::concat)
		System.out.println(word);
		BinaryOperator<Integer> op = (a,b) -> a*b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(3);
		Stream<Integer> threeElements = Stream.of(4,5,6);
		empty.reduce(op).ifPresent(System.out::println);
		oneElement.reduce(op).ifPresent(System.out::println);
		threeElements.reduce(op).ifPresent(System.out::println);
		Stream<Integer> threeElements2 = Stream.of(4,5,6);
		System.out.println(threeElements2.reduce(1,op,op));
		
		//collect()
		Stream<String> s6 = Stream.of("w", "o", "l", "f");
		StringBuilder wolf = s6.collect(StringBuilder::new, 
								StringBuilder::append,StringBuilder::append);
		System.out.println(wolf);
		Stream<String> s7 = Stream.of("w", "o", "l", "f");
		TreeSet<String> set1 = s7.collect(TreeSet::new, TreeSet::add, 
															TreeSet::addAll);
		System.out.println(set1); //ordered [f,l,o,w]
		Stream<String> s8 = Stream.of("w", "o", "l", "f");
		TreeSet<String> set2 = s8.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set2); //same
		Stream<String> s9 = Stream.of("w", "o", "l", "f");
		Set<String> set3 = s9.collect(Collectors.toSet()); // random order
		System.out.println(set3);
		
	
		//anyMatch(), allMatch(), noneMatch()
		List<String> list = Arrays.asList("monkey", "2", "chimp");
		Stream<String> infinite2 = Stream.generate(() -> "chimp");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		list.stream().anyMatch(pred);		//true
		list.stream().allMatch(pred);		//false
		list.stream().noneMatch(pred);		//false
		infinite2.anyMatch(pred);			//true
		
		//findAny() and findFirst()
		Stream<String> s3 = Stream.of("monkey", "ape", "bonobo");
		Stream<String> infinite1 = Stream.generate(() -> "chimp");
		s3.findAny().ifPresent(System.out::println);
		infinite1.findAny().ifPresent(System.out::println);
		
		//forEach()
		Stream<String> s4 = Stream.of("Monkey", "Ape", "Bonobo");
		s4.forEach(System.out::print);
		Stream s5 = Stream.of(1);
		//for(Integer i:s5) {}; //Streams are not Iterable and will not compile
	}

}
