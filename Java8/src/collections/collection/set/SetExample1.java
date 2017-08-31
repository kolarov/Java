package collections.collection.set;

// Sets do not allow duplicates. A Set is a Collection and does not define 
// additional methods.

import java.util.*;

public class SetExample1 {

	public static void main(String[] args) {
		
		//_____Implementations of Sets_____
		/* HashSet stores its elements in a hash table. 
  		 * - uses the hashCode() method of the objects to retrieve them more 
  		 * 	 efficiently
  		 * - adding elements and checking if an element is in the set both take
  		 *   constant time 
  		 * - calls hashCode()
  		 * - we lose order of insertion 
  		 * 
  		 * add:		O(1)
  		 * contains:O(1)
  		 * next:	O(h/n)  //where h is the table capacity
  		 * 
  		 * 
  		 * 
  		 * */
		int[] count = {34, 22, 10, 60, 30, 22};
	    Set<Integer> set = new HashSet<>();

	    for(int i = 0; i < 5; i++) {
	    	set.add(count[i]); //autoboxing to the wrapper Integer class 
	    }
	    set.add(7);   				//true
	    set.add(22);  				//false
	    set.add(new Integer(111));  //true
	    
	    System.out.println("The Hash is:");
	    System.out.println(set);
	    
	  
		
	    /* TreeSet stores its elements in a sorted tree structure. 
  		 * - always in sorted order
  		 * - adding element and checking if an element is in the set both have 
  		 *   O(log(n))
  		 * - implements Comparable
  		 * - implements the NavigableSet interface (sub-type of the SortedSet)
  		 * 			//methods in NavigableSet
  		 * 			E lower(E e)   greatest element <  e (or null if no such) 
  		 * 			E higher(E e)  smallest element >  e (or null if no such)
  		 * 			E floor(E e)   greatest element <= e (or null if no such)
  		 * 			E ceiling(E e) smallest element >= e (or null if no such)
  		 * 
  		 * add:		O(log(n))
  		 * contains:O(log(n))
  		 * next:	O(log(n))  
  		 * 
  		 *  
  		 * */
	    
	    // does not have a constructor that can work with count but a set is OK
	    TreeSet sortedSet = new TreeSet<Integer>(set);
	    System.out.println("The TreeSet is:");
	    System.out.println(sortedSet);
	    System.out.println(sortedSet.floor(35)); //NavigableSet interface
		
	}

}
