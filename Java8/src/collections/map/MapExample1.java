package collections.map;

/* _____ Map interface _____
 * Use a map when you want to identify  values by key.
 * We use the generics K for key objects and V for value objects. * 
 * 
 * V	 			get				(K key)
 * V	 			remove			(K key)
 * V				put 			(K key, V value)
 * void         	clear       	()
 * boolean    		isEmpty     	()
 * int          	size        	()
 * boolean 			containsKey		(K key)
 * boolean 			containsValue	(V value)
 * Set<K> 			keySet			()
 * Collection<V> 	values			()
 *  
 * _____ New Methods in Java 8 _____ 
 * V putIfAbsent	(K key, V value)
 * V merge			(K key, V value, BiFunction<? super V, ? super V,
 * 												? extends V> remappingFunction)
 * V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> 
 * 															 remappingFunction) 
 * 		Returns the new value associated with the specified key, or	null if none
 * V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
 * 		Returns the current (existing or computed) value associated with the 
 * 		specified key, or null if the computed value is null.	
 */

import java.util.*;
import java.util.function.*;

public class MapExample1 {
	public static void main(String[] args) {
		//_____ Implementations of Map _____
		/* HashMap stores the keys in a hash table 
		 * - uses the hashCode() of the keys to retrieve their values more 
		 * 	 efficiently
		 * - adding and retrieving elements both take constant time
		 * - we lose the order in which we inserted the elements 
		 * 
		 * 
		 * 
		 * */
		
		Map<String, String> map1 = new HashMap<>(); 
		map1.put("Koala", "8");
		map1.put("Koalaaa", "8");
		map1.put("Elephant", "31");
		map1.put("Lion", "12");
		map1.put("Giraffe", "14");
		
		System.out.println();
		System.out.println(" Map Elements");
		System.out.println("\t" + map1);   //Order is random/based on hashCode()
		System.out.println(map1.get("Lion"));
		// Using values(), the order of the values correspond to the order of the keys 
		for (String key : map1.keySet()) {   
			System.out.println(key + ", ");
		}
		System.out.println(map1.containsKey("Giraffe"));
		System.out.println(map1.containsValue("15"));
		System.out.println(map1.size());
		
		//putIfAbsent()
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Tram");
		favorites.put("Jenny", "BusTour");			//replace
		favorites.put("Tom", null);
		favorites.putIfAbsent("Jenny", "Tram");		//no effect
		favorites.putIfAbsent("Sam", "Tram");		//adds key
		favorites.putIfAbsent("Tom", "Tram");
		System.out.println(favorites);
		
		// computeIfPresent() and computeIfAbsent()
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 1);
		BiFunction<String, Integer, Integer> mapperB = (k,v) -> v + 1;
		Integer jenny = counts.computeIfPresent("Jenny", mapperB); //2
		Integer sam = counts.computeIfPresent("Sam", mapperB);	  //null
		System.out.println(counts);
		counts.put("Tom", null);
		Function<String, Integer> mapperF = (k) -> 1;
		jenny = counts.computeIfAbsent("Jenny", mapperF); 		//2
		sam = counts.computeIfAbsent("Sam", mapperF); 			//1
		Integer tom = counts.computeIfAbsent("Tom", mapperF);	//1
		System.out.println(counts);
		
		//merge()
		/* If nulls or missing keys are involved, the BiFunction is not called
		 * at all and it simply uses the new value. When the mapping f-n is 
		 * called and returns null, the key is removed from the map.
		 * */
		BiFunction<String, String, String> mapperM = 
				(v1,v2) -> v1.length() > v2.length()?v1:v2;
		BiFunction<String, String, String> mapperN = (v1,v2) -> null;
		Map<String, String> merged = new HashMap<>();
		merged.put("Jenny", "Bus Tour");		
		merged.put("Tom", "Train");
		String jny = merged.merge("Jenny", "Skyride", mapperM); //Bus Tour
		merged.merge("Tom", "Skyride", mapperM); 				//Skyride
		System.out.println(merged);
		merged.merge("Jenny", "Skyride", mapperN); //gets called and removes key
		merged.merge("John", "Skyride", mapperN); //not called, uses new value
		System.out.println(merged);

				
		/* TreeMap stores the keys in a sorted and navigable tree structure 
		 * - adding and checking if a key is present are both O(log(n)) 
		 *   operations
		 * 
		 * 
		 * */
		
		Map<String, String> map2 = new TreeMap<>(); 
		map2.put("Koala", "8");
		map2.put("Koalaaa", "8");
		map2.put("Elephant", "31");
		map2.put("Lion", "12");
		map2.put("Giraffe", "14");
		
		System.out.println();
		System.out.println(" Map Elements");
		System.out.println("\t" + map2);   // Sorted
		
		
		/* LinkedHashMap like HashMap but preserves the order of insertion of 
		 * the elements.
		 * 
		 * 
		 * */
		
		/* Hashtable is an old, thread-safe version of HashMap
		 * 
		 * 
		 * */
	}
}
