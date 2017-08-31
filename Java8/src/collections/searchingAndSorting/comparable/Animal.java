package collections.searchingAndSorting.comparable;

import java.util.*;

public class Animal implements Comparable<Animal> {
	private int id;
	@Override
	public int compareTo(Animal a) {
		return id - a.id; 			// sorts in ascending order		
	}								// a.id - id sorts in descending order 
	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		a1.id = 5;
		a2.id = 7;
		System.out.println(a1.compareTo(a2));
		System.out.println(a1.compareTo(a1));
		System.out.println(a2.compareTo(a1));
	}

}
