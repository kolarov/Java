package functionalProgramming.interfaces;

class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;
	public Animal(String species, boolean canHop, boolean canSwim) {
		this.species = species;
		this.canHop = canHop;
		this.canSwim = canSwim;
	}
	
	public boolean canHop() {
		return canHop;
	}

	public boolean canSwim() {
		return canSwim;
	}

	@Override
	public String toString() {
		return "Animal [species=" + species + "]";
	}
}
@FunctionalInterface
interface CheckTrait { //this only works with Animal class -> use Predicate!!!
	public boolean test(Animal a);
}

public class FunctionalInterfaceExample {
	private static void print(Animal a, CheckTrait trait) {
		if(trait.test(a))
			System.out.println(a);
	}
	public static void main(String[] args) {
		/* We are passing a lambda to a method expecting a CheckTrait 
		 * implementation. Thus Java treats CheckTrait as a FunctionalInterface
		 * and tries to map it to the single abstract method. 
		 * That method takes an Animal object and thus Java treats the lambda 
		 * parameter b as an Animal. Also we know that the lamda has to return 
		 * a boolean
		 *  
		 * */
		print(new Animal("fish", false, true), b -> b.canHop());
		print(new Animal("kangaroo", true, false), b -> b.canHop()); 

	}

}
