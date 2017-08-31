package advancedClassDesign.nestedClasses.innerClasses;

/* Defined at the member level of a class
 * Can use any access modifier
 * Can extend any class and implement interfaces
 * Can be abstract or final
 * Cannot declare static fields or methods
 * Can access all members of the outer class including private ones 
 * The compiler creates MemberInnerClassExample$Inner.class
 */

//_____OUTER CLASS_____
public class MemberInnerClassExample {
	private String hi = "Hi";
	private int x = 10;
	//private interface like this one can only be used within the outer class
	private interface Friendly{
		public void sayHi();
	}
	//_____INNER CLASS_____
	protected class Inner implements Friendly{
		// inner classes can have the same variable names as outer classes
		private String hi = "Hello";
		public int repetitions = 3;
		public void sayHi() {
			for(int i=0; i < repetitions; i++) {
				// no problem accessing private variable(hi) in the outer class
				System.out.println(this.hi); //same as just printing hi 
				System.out.println(MemberInnerClassExample.this.hi);
			}
		}
	}
	
	public void callInner() {
		Inner inner = new Inner();
		inner.sayHi();
	}
	public static void main(String[] args) {
		MemberInnerClassExample outer = new MemberInnerClassExample();
		System.out.println("Using a dedicated method to get an Inner instance");
		outer.callInner();
		System.out.println("Using 'outer.new Inner()' directly");
		Inner inner = outer.new Inner();
		inner.sayHi();
		
	}

}
