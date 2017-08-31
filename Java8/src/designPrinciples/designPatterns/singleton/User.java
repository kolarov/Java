package designPrinciples.designPatterns.singleton;

import designPrinciples.designPatterns.singleton.HayStorageLazyInst;

//There can be many User objects but only one HayStorageLazyInst
public class User {
	public boolean feedAnimals(int numOfAnimals) {
		int amountNeeded = 1*numOfAnimals;
		HayStorageLazyInst hayStorage = HayStorageLazyInst.getInstance();
		if(hayStorage.getHayQuantity() < amountNeeded)
			hayStorage.addHay(amountNeeded+10);
		boolean fed = hayStorage.removeHay(amountNeeded);
		if(fed) {
			System.out.println("Animals are fed !!!");
			System.out.println("Quantity of hay: "+hayStorage.getHayQuantity());
		}
		return fed;
	}
	public static void main(String[] args) {
		User user = new User();
		user.feedAnimals(3);
		user.feedAnimals(3);
		user.feedAnimals(3);
		user.feedAnimals(3);
		user.feedAnimals(3);
		User user2 = new User(); //uses the same instance of HayStorageLazyInst
		user2.feedAnimals(2);

	}

}
