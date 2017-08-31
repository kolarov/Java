package designPrinciples.designPatterns.immutable;

import java.util.*;

import designPrinciples.designPatterns.immutable.Animal;


// If we want to modify an immutable object we must create a new one.
public class User {

	public static void main(String[] args) {
		Animal l1 = new Animal("lion",10,Arrays.asList("meat", "more meat"));
		System.out.println(l1.getSpecies() + "'s age: " + l1.getAge());
		System.out.println("Number of faavorite foods: " 
											+ l1.getFavoriteFoodsCount());
		//Increase the age of an animal by one year
		List<String> favoriteFoods = new ArrayList<String>();
		for (int i = 0; i < l1.getFavoriteFoodsCount(); i++) {
			favoriteFoods.add(l1.getFavoriteFood(i));
		}
		Animal l2 = new Animal(l1.getSpecies(), l1.getAge() + 1, favoriteFoods);
		System.out.println(l2.getSpecies() + "'s age: "+ l2.getAge());
		System.out.println("Number of faavorite foods: " 
												+ l2.getFavoriteFoodsCount());
	}
}
