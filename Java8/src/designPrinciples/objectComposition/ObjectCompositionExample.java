package designPrinciples.objectComposition;

/*
 * Object Composition is the construction of class using references to other
 * classes in order to reuse the functionality of the other classes. The class
 * contains the other classes in a has-a sense and may delegate methods to the
 * other classes. 
 * Object composition is an alternative to inheritance and is often used to 
 * simulate polymorphic behavior that cannot be achieved via single inheritance.
 * It generally promotes greater code reuse than inheritance.
 * However, you have to explicitly expose the underlying methods and values,
 * whereas inheritance includes protected and public members automatically..
 * 
 */

class Flippers {
	public void flap() {
		System.out.println("Flapping");
	}
}
class WebbedFeet {
	public void kick() {
		System.out.println("Kicking");
	}
}
class Penguin {
	private final Flippers flippers;
	private final WebbedFeet webbedFeet;
	public Penguin() {
		this.flippers = new Flippers();
		this.webbedFeet = new WebbedFeet();
	}
	// explicitly expose the underlying methods
	public void flap() { 
		this.flippers.flap(); 
	}
	public void kick() {
		this.webbedFeet.kick();
	}
	
}

public class ObjectCompositionExample {
	
	public static void main(String[] args) {
		Penguin p = new Penguin();
		p.flap();
		p.kick();

	}

}
