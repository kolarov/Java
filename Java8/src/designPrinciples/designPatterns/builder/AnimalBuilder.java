package designPrinciples.designPatterns.builder;

import java.util.*;

import designPrinciples.designPatterns.immutable.Animal;

/*
 * As our data objects grow in size, the constructor may grow to contain many
 * attributes. The builder pattern is a creational pattern in which parameters
 * are passed to a builder object, often through method chaining, and an object
 * is generated with a final build() call. It is often used with immutable
 * objects.
 * The builder pattern lead to more maintainable code
 */
//AnimalBuilder is a mutable class that is tightly coupled with the Animal class
public class AnimalBuilder {
	private String species;
	private int age;
	private List<String> favoriteFoods;
	
	//setters like this allow chaining
	public AnimalBuilder setSpecies(String species) {
		this.species = species;
		return this;
	}
	public AnimalBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
		return this;
	}
	//at the end we build the immutable object and return it
	public Animal build() {
		return new Animal(species, age, favoriteFoods);
	}
	
	
}
