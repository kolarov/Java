package designPrinciples.designPatterns.builder;

import java.util.*;

import designPrinciples.designPatterns.builder.AnimalBuilder;
import designPrinciples.designPatterns.immutable.Animal;

public class User {

	public static void main(String[] args) {
		Animal bear = new AnimalBuilder()
						.setFavoriteFoods(Arrays.asList("honey", "berries"))
						.setSpecies("bear")
						.build();
		//we can also write the build() method to set default values or throw 
		//an exception if certain required fields are not set. 
		System.out.println(bear.getSpecies() + "'s age: " + bear.getAge());
		System.out.println("Number of faavorite foods: " 
											+ bear.getFavoriteFoodsCount());
	}

}
