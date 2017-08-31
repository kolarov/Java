package collections.searchingAndSorting.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import collections.searchingAndSorting.comparator.Duck;

public class Examples {
	
	static class Rabbit { int id; }
	
	public static void main(String[] args) {
		//_____ Comparators _____
		Comparator<Duck> byWeight = new Comparator<Duck>() { //inner class
			@Override
			public int compare(Duck o1, Duck o2) {
				return o1.getWeight()-o2.getWeight();
			}
		};
		//Comparator is a functional interface and we can use lambda as well
		Comparator<Duck> byWeightReverse = 
			(d1, d2) -> d2.getWeight() - d1.getWeight(); //descending order
		//Thanks to static and default methods we can compare on multiple fields
		class ChainingComparator implements Comparator<Duck> {
			public int compare(Duck d1, Duck d2) {
				Comparator<Duck> c = Comparator.comparing(s->s.getWeight());
				c = c.thenComparing(s->s.getName());
				return c.compare(d1, d2);
			}
		}
			
			
		List<Duck> ducks1 = new ArrayList<>();
		ducks1.add(new Duck("Quack",7));
		ducks1.add(new Duck("Puddles",10));
		System.out.println("Original: " + ducks1);
		Collections.sort(ducks1);   // sorts by name (ascending alphabetically)
		System.out.println("By name: " + ducks1);
		Collections.sort(ducks1, byWeight);
		System.out.println("By weight: " + ducks1);
		Collections.sort(ducks1, byWeightReverse);
		System.out.println("By weight in reverse: " + ducks1);
		Collections.sort(ducks1, new ChainingComparator());
		System.out.println("By weight: " + ducks1);
		
		// sort() and binarySearch() allow you to pass in a Comparator object 
		// when you don't want to use natural order.
		List<String> names = Arrays.asList("Fluffy", "Happy");
		Comparator<String> c = Comparator.reverseOrder();
		int index = Collections.binarySearch(names, "Hoppy", c);
		//The comparator reverses the natural order and thus the binarySearch()
		//REQUESTS a list sorted in descending order but names is sorted in 
		//ascending order and thus we get an undefined answer (-1)
		System.out.println(index); //-1
		
		Set<Duck> ducks2 = new TreeSet<>();
		ducks2.add(new Duck("Duffy", 5));
		//Set<Rabbit> rabbits = new TreeSet<>();
		//rabbits.add(new Rabbit());  //throws ClassCastException
		Set<Rabbit> rabbits = new TreeSet<>(new Comparator<Rabbit>() { 
			public int compare(Rabbit r1, Rabbit r2) {
				return r1.id - r2.id;
			}
		});
		rabbits.add(new Rabbit()); //now that is OK
		
		Comparator<Duck> byWeight2=(d1, d2)->DuckHelper.compareByWeight(d1, d2);
		//We can do the same with a method reference
		Comparator<Duck> byWeight21=DuckHelper::compareByWeight;
		Collections.sort(ducks1, byWeight2);
		System.out.println("By weight: " + ducks1);
		
	}
}
