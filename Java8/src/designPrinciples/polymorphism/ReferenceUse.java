package designPrinciples.polymorphism;

/*
 * Polymorphism also allows one object to take on many different forms when
 * accessed with different references. A cast is not required if the object is 
 * being reassigned to a supertype or interface of the class.
 * 
 * If you use a variable to refer to an object, then only the methods or 
 * variables that are part of the variable's reference type can be called 
 * without an explicit cast.
 * 
 * - casting from a subclass to a superclass doesn't require an explicit cast
 * - casting from a superclass to a subclass requires an explicit cast
 * - compilation error if we cast to unrelated types
 * - even after compilation we can get a ClassCastException
 * 
 * */

class Primate {
	public boolean hasHair() {
		return true;
	}
}
interface HasTail {
	public boolean isTailStripped();
}

public class ReferenceUse extends Primate implements HasTail {
	private int age;
	public boolean isTailStripped() {
		return false;
	}
	public static void main(String[] args) {
		//single object
		ReferenceUse lemur = new ReferenceUse();
		
		System.out.println(lemur.age);
		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStripped());
		Primate primate = lemur;
		System.out.println(primate.hasHair());
		//lemurX will not compile because it needs an explicit downcast
		//ReferenceUse lemurX = primate;
		ReferenceUse lemur2 = (ReferenceUse)primate;
		
		Primate p = new Primate();
		//The following line leads to a ClassCastException
		//ReferenceUse r = (ReferenceUse)p;
		
		//to avoid exceptions we can use 
		if (p instanceof ReferenceUse) {
			ReferenceUse r = (ReferenceUse)p;
		}
		
	}

}
