package functionalProgramming.interfaces;

import java.time.*;
import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		
		/* @FunctionalInterface
		 * public interface Supplier <T> {
		 * 		public T get();
		 * }
		 * 
		 * */
		Supplier <LocalDate> s1 = LocalDate::now;  			//calling a factory 
		Supplier <LocalDate> s2 = () -> LocalDate.now(); 	//same
		LocalDate d1 = s1.get();
		LocalDate d2 = s2.get();
		Supplier<StringBuilder> s3 = StringBuilder::new;//calling a constructor
		Supplier<StringBuilder> s4 = () ->  new StringBuilder("Hi");
		System.out.println(s4.get());
		Supplier<ArrayList<String>> s5 = ArrayList<String>::new; //still ok

		/* @FunctionalInterface
		 * public interface Consumer <T> {
		 * 		public void accept(T t);
		 * }
		 * 
		 * @FunctionalInterface
		 * public interface BiConsumer <T,U> {
		 * 		public void accept(T t, U u);
		 * }
		 * 
		 * */
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);
		c1.accept("Annie");
		c2.accept("Annie");
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String,Integer> bc1 = map::put;
		BiConsumer<String,Integer> bc2 = (k,v) -> map.put(k, v);
		bc1.accept("chick", 1);
		bc2.accept("chicken", 7);
		System.out.println(map);
		
		/* @FunctionalInterface
		 * public interface Predicate <T> {
		 * 		boolean test(T t);
		 * }
		 * 
		 * @FunctionalInterface
		 * public interface BiPredicate <T,U> {
		 * 		boolean test(T t, U u);
		 * }
		 * */
		Predicate<String> p1 = String::isEmpty;
		Predicate<String> p2 = x -> x.isEmpty();
		System.out.println(p2.test(""));
		BiPredicate<String, String> b1 = String::startsWith;
		BiPredicate<String, String> b2 = (str,prefix) -> str.startsWith(prefix);
		System.out.println(b2.test("chicken", "chi"));
		Predicate<String> egg = s -> s.contains("egg");
		Predicate<String> brown = s -> s.contains("brown");
		//there are convenience default method in the functional interfaces
		Predicate<String> nonBrownEgg = egg.and(brown.negate());
		
		/* @FunctionalInterface
		 * public interface Function <T,R> {
		 * 		R apply(T t);
		 * }
		 * 
		 * @FunctionalInterface
		 * public interface BiFunction <T,U,R> {
		 * 		R apply(T t, U u);
		 * }
		 * */
		Function<String, Integer> f1 = String::length;
		Function<String, Integer> f2 = s -> s.length(); //int autoboxed 
		System.out.println(f2.apply("Happy")); 
		BiFunction<String, String, String> bf1 = String::concat;
		BiFunction<String, String, String> bf2 = (str1,str2)->str1.concat(str2);
		System.out.println(bf2.apply("Happy", " Birthday")); 
		
		/* @FunctionalInterface
		 * public interface UnaryOperator <T> {
		 * 		extends Function <T,T> {}
		 * }
		 * 
		 * @FunctionalInterface
		 * public interface BinaryOperator <T> {
		 * 		extends BiFunction <T,T,T> {}
		 * }
		 * 
		 * */
		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = x -> x.toUpperCase();
		System.out.println(u2.apply("chirp"));
		BinaryOperator<String> bo1 = String::concat;
		BinaryOperator<String> bo2 = (str,toAdd) -> str.concat(toAdd);
		System.out.println(bo2.apply("beer"," pong"));
		
		
		
	}

}
