package designPrinciples.designPatterns.singleton;

/*
 * With Lazy Instantiation we delay the creation of the singleton until the
 * first time the getInstance() method is called.
 * In this example every call to the getInstance() method will require 
 * synchronization, which can impact performance. 
 * The solution is to use double-checked locking 
 */

public class HayStorageLazyInst {
	private int quantity = 0;

	private HayStorageLazyInst() {
	}

	// _____LAZY INSTANTIATION_____
	// the instance cannot be final when we use lazy instantiation
	private static HayStorageLazyInst instance;
	// synchronized => thread safe; ensures only one instance can be made
	public static synchronized HayStorageLazyInst getInstance() {
		if (instance == null) {
			System.out.println("Instantiating HayStorageLazyInst");
			instance = new HayStorageLazyInst();
		}
		return instance;
	}
	// _____END LAZY INSTANTIATION_____

	public synchronized void addHay(int amount) {
		quantity += amount;
	}

	public synchronized boolean removeHay(int amount) {
		if (quantity < amount)
			return false;
		quantity -= amount;
		return true;
	}

	public synchronized int getHayQuantity() {
		return quantity;
	}

}
