package advancedClassDesign.virtualMethods;

/*
 * All regular non-static methods are VIRTUAL! Java looks for an overridden
 * method rather than necessarily using the one in the class that the compiler
 * says we have!
 */
abstract class Animal {
	String classType = "Animal";
	String action = "pet animal ";

	public void play() {
		System.out.println("Method declared in class: " + classType + "\n"
				+ "That method uses instance variable in class: " + classType);
	}

	public void careFor() {
		play(); // virtual method invocation
		// However, whenever a method uses a variable, it uses the variable from
		// the class where the method is
		System.out.println("However, instance variable in class: " + classType);
	}
}

class Lion extends Animal {
	String classType = "Lion";
	String action = "toss in meat ";

	@Override
	public void play() {
		System.out.println("Method declared in class: " + classType + "\n"
				+ "That method uses instance variable in class: " + classType);
	}
}

public class VirtualPlay {

	public static void main(String[] args) {
		Animal lio = new Lion();
		// calls the overridden method from the object type
		// uses the instance variable from the reference type
		lio.careFor();

	}

}
