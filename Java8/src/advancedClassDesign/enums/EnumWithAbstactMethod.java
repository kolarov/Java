package advancedClassDesign.enums;

public enum EnumWithAbstactMethod {

	// the semicolon at the end is now OBLIGATORY
	WINTER{
		 public void printHours() {System.out.println("9-17");}
		 public void printDayLength() {System.out.println("Days are short!");}
	},
	SUMMER{
		 public void printHours() {System.out.println("9-20");}
		 public void printDayLength() {System.out.println("Days are long!");}
	},
	SPRING{
		 public void printHours() {System.out.println("9-19");}
	},  
	AUTUMN{
		 public void printHours() {System.out.println("9-18");}
	};
	//Every value is required to implement the abstract method
	public abstract void printHours();
	//Override the default implementation only in the special cases
	public  void printDayLength() {
		System.out.println("Days are medium in length!");
	};
	public static void main(String... args) {
		for(EnumWithAbstactMethod e : EnumWithAbstactMethod.values()) {
			e.printHours();
			e.printDayLength();
		}
	}
	
}
