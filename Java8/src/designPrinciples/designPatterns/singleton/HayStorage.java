package designPrinciples.designPatterns.singleton;

/*
 * The singleton pattern is a creational pattern focused on creating only one
 * instance of an object in memory within an application, sharable by all
 * classes and threads.
 * Singletons can improve performance by loading reusable data that would 
 * otherwise be time consuming to store and reload each time it is needed.
 * It is often used for configuration data and data caches.  
 */


//The class is effectively final since all its constructors are private
public class HayStorage { 
	private int quantity = 0;
	private HayStorage() {} //private => no other class can instantiate it
	private static final HayStorage instance = new HayStorage();

	public static HayStorage getInstance() { //get access to the instance
		return instance;
	}
	//We can instead use a static initialization block, allowing additional 
	//steps to be taken to set up the singleton after it has been created
	/*private static final HayStorage instance; 
	static{
		instance = new HayStorage();
		//perform additional steps
	}*/
	
	
	//synchronized => prevent two processes from running the same method at 
	//the same time
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
