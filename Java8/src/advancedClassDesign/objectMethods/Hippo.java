package advancedClassDesign.objectMethods;

public class Hippo {

	private String name;
	private double weight;

	public Hippo(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	// toString() is called if we try to print an object
	@Override
	public String toString() {
		return "Hippo [name=" + name + ", weight=" + weight + "]";
	}

	// A hash code is a number that puts instances of a class into a finite
	// number of categories (think keys of a map). Whenever we override equals()
	// we are expected to override hashCode() as well. Within the same program,
	// the result of hashCode() must not change. If equals() returns true,
	// calling hashCode() on each of the two objects MUST return the same
	// result.
	@Override
	public int hashCode() {
		final int prime = 31; // common to multiply by a prime number
		int result = 1;
		// NOT all of the instance variables need to be used (CAN use a subset
		// of the variables that equals() uses).
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	// Java uses == to compare primitives and for checking if two variables
	// refer to the same object. Checking if two objects are equivalent uses the
	// equals() method. X.equals(null) must return false and not an exception.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Hippo))
			return false;
		Hippo other = (Hippo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	public static void main(String[] args) {
		String s1 = new String("lion");
		String s2 = new String("lion");
		StringBuilder sb1 = new StringBuilder("lion");
		StringBuilder sb2 = new StringBuilder("lion");
		Hippo h1 = new Hippo("Hippier Hippo", 5000);
		Hippo h2 = new Hippo("Hippiest Hippo", 6000);
		// String class has an overridden equals() method that checks if values
		// are the same
		System.out.println("Are the Strings equal: " + s1.equals(s2));
		// StringBuilder uses the equals() implementation provided by Object. It
		// checks if sb1 == sb2.
		System.out.println("Are the StringBuilders equal: " + sb1.equals(sb2));
		// The Hippiest Hippo is one and only =)
		System.out.println("Are the Hippos equal: " + h1.equals(h2));
	}

}
