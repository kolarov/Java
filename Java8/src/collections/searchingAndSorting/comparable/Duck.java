package collections.searchingAndSorting.comparable;

/* @FunctionalInterface
 * public interface Comparable <T> {
 *     public int compareTo(T o)
 * }
 * 
 * compareTo():
 * - return 0 when the current object is equal to the argument
 * - return <0 when the current object is smaller than the argument 
 * - return >0 when the current object is larger than the argument 
 * - in legacy code (without generics) it requires a cast 
 * 
 * The compareTo() method returns 0 if two objects are equal, while equals()
 * method returns true if two objects are equal. A natural ordering that uses
 * compareTo() is said to be consistent with equals if and only if x.equals(y)
 * is true whenever x.compareTo(y) equals 0.
 * 
 * */


import java.util.*;

public class Duck implements Comparable<Duck>{
	private String name;
	public Duck(String name) {
		this.name = name;
	}
	@Override
	public String toString() {             
		return "Duck [name=" + name + "]";
	}
	@Override
	public int compareTo(Duck d) {     //delegates to String's compareTo()
		return name.compareTo(d.name);
	}

	public static void main(String[] args) {
		List<Duck> ducks = new ArrayList<>();
		ducks.add(new Duck("Quack"));
		ducks.add(new Duck("Puddles"));
		Collections.sort(ducks);   // sorts by name (ascending alphabetically)
		System.out.println(ducks);
	}

}
