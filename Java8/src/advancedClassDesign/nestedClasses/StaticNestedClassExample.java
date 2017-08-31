package advancedClassDesign.nestedClasses;

/*
 * A Static Nested Class is not inner class. It is a static class defined at 
 * the member level. Can be instantiated without an object of the enclosing 
 * class, thus it cannot access the instance variables without an explicit 
 * object of the enclosing class.
 * Can be made private or use another access modifier.
 * The enclosing class can refer to the fields and methods of the static nested 
 * class. 
 * Importing a static nested class can be done by either a regular or a static
 * import. 
 * 
 * */
public class StaticNestedClassExample {
	static class Nested {
		private int price = 60;
	}
	public static void main(String[] args) {
		Nested n = new Nested(); //directly
		System.out.println(n.price);

	}
//test change
}
