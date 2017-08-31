package collections.collection.list;

/* _____ Collection interface _____
 * The object type below is associated with raw collection. When we work with 
 * generics the Object is actually of type E (element) that is specified when 
 * creating the collection. The implementations of the interfaces present in the 
 * Collections Framework are allowed to add their own behavior.
 * 
 * boolean  add			(Object element)
 * boolean  addAll		(Collection c)
 * boolean  remove		(Object element)
 * boolean  removeAll	(Collection c)
 * boolean  retainAll	(Collection c)
 * boolean  contains	(Object element)
 * boolean  containsAll	(Collection c)
 * int 	    size		()
 * void     clear		()
 * boolean  isEmpty		()
 * Object[] toArray		()
 * Iterator iterator	()
 * 					// methods in the Iterator interface
 * 					boolean hasNext()
 * 					Object 	next()
 * 					void 	remove()
 * _____ New Methods in Java 8 _____
 * boolean	removeIf	(Predicate<? super E> filter) 
 * void		forEach		(Consumer<? super T> action)  //from Iterable interface
 *   
 * 
 *  
 */

/* _____ List interface _____
 * A list is an ordered collection that can contain duplicates. Items can be 
 * retrieved and inserted at specific positions in the list based on an index.
 * 
 * void 		add			(int index, Object element)
 * boolean 		addAll		(int index, Collection c)
 * Object 		get			(int index)
 * int 			indexOf		(Object element)
 * int 			lastIndexOf	(Object element)
 * Object 		remove		(int index)
 * Object		set			(int index, Object element)
 * List 		subList		(int start, int end)
 * ListIterator listIterator()
 * ListIterator listIterator(int index)
 * 
 * _____ New Methods in Java 8 _____
 * void		replaceAll	(UnaryOperator<E> operator)   
 *  
 */

import java.util.*;

public class ListExample1 {
	
	public static void main(String[] args) {
		
		//_____ Implementations of List _____
		
		/* ArrayList is like a resizable(dynamic) array. 
		 * - look up any element in constant time
		 * - adding or removing an element is slower than getting an element
		 * - good choice when you are reading more often than writing
		 * 
		 * The implementations used when calling asList()has the added feature
		 * of not being resizable!
		 * 
		 * get:		O(1)
		 * add:		O(1)
		 * contains:O(n)
		 * next:	O(1)
		 * remove:	O(n)
		 * 
		 * 
		 * */
		List<String> a1 = new ArrayList<>(); //raw types result in warnings
		System.out.println(" ArrayList Elements");
		a1.add("NJ");     //[NJ]
		a1.add(0, "NY");  //[NY, NJ] we have overloaded remove
		a1.set(1, "FL");  //[NY, FL]
		a1.remove("NY");  //[FL]
		a1.remove(0);     //[] we have overloaded remove
		a1.add("SD");
		a1.add("OH");
		a1.add("CO");
		System.out.println("\t" + a1);
		System.out.println("\t" + a1.get(1));
		System.out.println("\t" + a1.indexOf("OH"));
		
		
		
		String[] arr1 = {"gerbil", "mouse"};
		List<String> list1 = Arrays.asList(arr1); //this in not an ArrayList
		//Changes in either list and arr1 are reflected in both since they are 
		//backed by the same data
		list1.set(1, "test"); 
		arr1[0] = "new";       // [new, test]
		String[] arr2 = (String[]) list1.toArray();
		System.out.println(list1);
		//list.remove(1); // UnsupportedOperationException
		
		List<Integer> list2 = Arrays.asList(9,7,5,3);
	    Collections.sort(list2);
	    System.out.println(Collections.binarySearch(list2, 3));    // 1
	    System.out.println(Collections.binarySearch(list2, 2));    // -1
		
		//Iterating over list
		for(String str : a1) {
			System.out.println(str);
		}
		//OR
		Iterator<String> iter1 = a1.iterator(); 
		while(iter1.hasNext()) {
			String str = iter1.next();
			System.out.println(str);
		}
		//OR
		Iterator iter2 = a1.iterator(); //the way to use Iterator before Java5
		while(iter2.hasNext()) {
			String str = (String) iter2.next();
			System.out.println(str);
		}
		
		
		//Let's see the new methods in action
		a1.replaceAll(x -> "OMG");
		System.out.println("\t" + a1);
		a1.forEach(System.out::print);
		a1.removeIf(s -> s.startsWith("O"));
		System.out.println("\t" + a1);
		
		/* LinkedList implements both List and Queue interfaces.
		 * - access(), add() and remove() from the beginning and/or end of the 
		 *   list happen in constant time (has additional methods from Queue)
		 * - dealing with an arbitrary index takes linear time
		 * - good choice as a Queue
		 * 
		 * 
		 * 
		 * get:		O(n)
		 * add:		O(1)
		 * contains:O(n)
		 * next:	O(1)
		 * remove:	O(1)
		 * 
		 * */
		List l1 = new LinkedList();
		l1.add("Zara");
		l1.add("Mahnaz");
		l1.add("Ayan");
		l1.add(6);       // OK since this is a raw LinkedList
		System.out.println();
		System.out.println(" LinkedList Elements");
		System.out.print("\t" + l1);
		
		/* Vector - outdated, thread-safe, slower version of ArrayList
		 * 
		 * 
		 * */
		
		/* Stack - outdated data structure that extends Vector. If you need a 
		 * 		   stack, use an ArrayDeque 
		 * 
		 * */
	}

}
