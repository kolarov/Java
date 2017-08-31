package designPrinciples.designPatterns.immutable;

import java.util.*;
/*
 * Immutable is a class based on the  idea of creating read-only objects, whose 
 * state does not change after they are created and can be easily shared across
 * multiple classes.
 * Immutable objects go hand and hand with encapsulation, but without setters.
 * They are inherently thread-safe. 
 * - use a constructor to set all properties of the object
 * - mark all of the instance variables private and final
 * - don't use setter methods
 * - don't allow referenced mutable objects to be modified or accessed directly
 * - prevent methods from being overridden (make the class or the methods final
 *   or make the constructor private and use the Factory pattern)
 * */
public final class Animal {
	private final String species;
	private final int age;
	private final List<String> favoriteFoods;
	public Animal(String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;
		if(favoriteFoods == null) 
			throw new RuntimeException("favoriteFoods is required!");
		//All mutable input arguments must be copied !!!
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}
	public String getSpecies() {
		return species;
	}
	public int getAge() {
		return age;
	}
	public int getFavoriteFoodsCount() {
		return favoriteFoods.size();
	}
	public String getFavoriteFood(int index) {
		return favoriteFoods.get(index);
	}
//	the following getter makes the whole class mutable
//	public List<String> getFavoriteFoods() {
//		return favoriteFoods;
//	}
	
	
	
}
