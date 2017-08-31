package advancedClassDesign.enums;

// Cannot have a public enum and a public class in the same file since enums are
// classes themselves. Enums are better than a bunch of constants since they
// provide type-safe checking. Enums can't be extended!
enum Seasons1 {
	WINTER, SPRING, SUMMER, AUTUMN // the semicolon at the end is OPTIONAL
}

// Enums can have more in them than just values. It is common to give state to
// each one. The first time we ask for any of the enum values, Java constructs
// all of them. This happens only once!
enum Seasons2 {
	// the semicolon at the end is now OBLIGATORY
	WINTER("low"), SPRING("medium"), SUMMER("high"), AUTUMN("medium");
	private String expectedVisitors;

	// the code will NOT compile with a public constructor
	private Seasons2(String expectedVisitors) {
		System.out.println("Calling the enum constructor!");
		this.expectedVisitors = expectedVisitors;
	}

	public String getExpectedVisitors() {
		return expectedVisitors;
	}
}



public class EnumExamples {

	public static void main(String[] args) {
		Seasons1 s1 = Seasons1.SUMMER;
		System.out.println(Seasons1.SUMMER);
		System.out.println(s1 == Seasons1.SUMMER);
		for (Seasons1 season : Seasons1.values()) {
			System.out.println(season.name() + " " + season.ordinal());
		}
		
		Seasons2 s2 = Seasons2.SUMMER;
		System.out.println(Seasons2.valueOf("SUMMER"));
		// However, the following leads to an IllegalArgumentException
		//System.out.println(Seasons2.valueOf("Summer"));
		// The following line makes Java construct all the enum values (4 calls)
		System.out.println(Seasons2.SUMMER.getExpectedVisitors());
		for (Seasons2 season : Seasons2.values()) {
			// The constructor does not get called here
			System.out.println(season.name() + " " + season.getExpectedVisitors());
		}
		switch(s2) {  
		case SUMMER:      // if we use Seasons2.SUMMER or 0 => won't compile
			System.out.println("Time to party!"); //missing break => we go to next case
		case WINTER:
			System.out.println("Time to hide!");
			break;
		default:
			System.out.println("Time to work!");
		}
		
		
	}

}
