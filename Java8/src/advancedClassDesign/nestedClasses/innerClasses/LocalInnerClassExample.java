package advancedClassDesign.nestedClasses.innerClasses;

/*
 * Local Inner Class is a nested class defined within a method. Like local
 * variables, its declaration does not exist until the method is invoked, and it
 * goes out of scope when the method returns. This means you can create
 * instances of a local inner class only from within the method (the instances
 * can still be returned from the method).
 * - do not have an access specifier
 * - cannot be declared static and cannot declare static fields or methods
 * - have access to all members of the enclosing class
 * - do not have access to the local variables of the method unless they are 
 *   final or effectively final.
 * If the code could still compile with the keyword final inserted before the 
 * local variable, the variable is effectively final 
 * 
 * Anonymous Inner Class is a local inner class that does not have a name. It 
 * is declared and instantiated all in one statement. It is required to extend
 * an existing class or implement an existing interface.
 * You cannot implement both an interface and extend a class, unless the class 
 * to extend is java.lang.Object.
 */

//_____OUTER CLASS_____
public class LocalInnerClassExample {
	
	private int length = 5;
	
	public void calculate() {
		final int width = 20;
		int one = 20; //effectively final
		int two = one;
		two++;
		int three; //effectively final
		if(one==4) three = 3;
		else three = 4;
		//_____LOCAL INNER CLASS_____
		class Inner {
			public void multiply() {
				System.out.println(length * width);
				System.out.println("one = " + one + "; three = " + three);
				// But if we try to print 'two' the code will not compile!
			}
		}
		Inner inner = new Inner();
		inner.multiply();
	}
	
	abstract class Sale { abstract int discount(); }
	interface Cheap { int discount(); }
	
	public Sale goShopping() {
		//_____ANONYMOUS INNER CLASS from a class_____
		Sale sale = new Sale() {
			int discount(){
				System.out.println("ANONYMOUS INNER CLASS from a class");
				return 3;
			}
		};
		//_____ANONYMOUS INNER CLASS from an interface_____
		Cheap stockPrice = new Cheap() {
			public int discount() { //interfaces require public methods!!!
				return 3;
			}
		};
		
		return sale;
	}
	
	

	public static void main(String[] args) {
		LocalInnerClassExample outer = new LocalInnerClassExample();
		outer.calculate();
		System.out.println(outer.goShopping().discount());

	}

}
