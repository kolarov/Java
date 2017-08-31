package advancedClassDesign.ocaConcepts.species;

import advancedClassDesign.ocaConcepts.BigCat;
import static java.util.Collections.sort; //static method

/*Overloading:
 * - exact match
 * - matching a superclass type
 * - converting to a larger primitive 
 * - autoboxed type
 * - varargs
 * 
 * Overriding:
 * - access modifier must match or be more accessible
 * - return type must be the same or more restrictive
 * - if any checked exceptions are thrown they must match or be of a subclass
 * - the method must not be static (hidden otherwise)
 * 
 * final: prevents a variable from chaining or a method from being overridden
 * adding final on the class level means that the class can't be subclassed
 */
class Felinae {}
class Lion extends BigCat {}

@SuppressWarnings("unused")
public class Lynx extends BigCat {
	
	public static void main(String[] args) {
		
		// _____ACCESS MODIFIERS_____
		// Here the reference type is important
		// BigCat lynx = new Lynx(); BigCat does not inherit from BigCat !!!
		// Access through inheritance works (protected modifier in BigCat)
		Lynx lynx1 = new Lynx();
		BigCat lynx2 = new Lynx();
		BigCat lio = new Lion();
		Lynx nullLynx = null;
		
		System.out.println(lynx1.name);
		System.out.println(lynx1.hasFur);
		
		// _____instanceof_____
		boolean isLynx = lynx1 instanceof Lynx; 			//true
		boolean isBigCat = lynx1 instanceof BigCat; 		//true
		boolean isObject = lynx1 instanceof Object; 		//true
		// if we use lynx1 instead of lynx2 the following won't compile
		boolean isLion = lynx2 instanceof Lion; 			//false
		boolean nullIsObject = nullLynx instanceof Object; 	//false
		// But the following will not compile at all since the two classes are
		// unrelated. This compilation check does not apply to interfaces.
		// boolean isFelinae = lynx instanceof Felinae;
		
		System.out.println("Lynx is a Linx: " + isBigCat);
		System.out.println("Linx is a BigCat: " + isBigCat);
		System.out.println("Linx is an Object: " + isObject);
		System.out.println("Linx is a Lion: " + isLion);
		System.out.println("null is an Object: " + nullIsObject);

	}

}
