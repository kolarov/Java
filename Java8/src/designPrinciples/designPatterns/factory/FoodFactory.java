package designPrinciples.designPatterns.factory;

/*
 *   
 * The Factory pattern is a creational pattern based on the idea of using a 
 * factory class to produce instances of objects based on a set of input 
 * parameters. It allows us to write code that creates objects whose precise 
 * type may not be known until runtime. It is similar to the Builder pattern, 
 * although it is focused on supporting class polymorphism. It is often, but 
 * not always, implemented using static methods that return objects and do not 
 * require a pointer to an instance of the factory class. 
 * 
 * 
 * */
public class FoodFactory {
	public static Food getFood(String animalName) {
		switch (animalName) {
			case "zebra": return new Hay(100);
			case "rabit": return new Pallets(5);
			case "goat": return new Pallets(30);
			case "bear": return new Fish(10);
		}
		throw new UnsupportedOperationException("Unsuppoeted animal: " 
																+ animalName);
		
	}
}
