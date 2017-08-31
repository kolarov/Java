package designPrinciples.designPatterns.factory;

/*
 * The loose coupling of User and Food allows us to change the rules in the 
 * FoodFactory at a later date without code changes to User.
 * 
 *  As an alternative to using a factory pattern, a developer could implement a 
 *  set of Animal classes and define a getFood() method in each. However, this
 *  leads to tight coupling and loss of flexibility.
 *  
 * */
public class User { // not concerned with type of Food

	public static void main(String[] args) {
		final Food food = FoodFactory.getFood("bear");
		food.consumed();

	}

}
