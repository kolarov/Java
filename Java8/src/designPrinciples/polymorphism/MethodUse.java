package designPrinciples.polymorphism;

/*
 * Polymorphism is the ability of a single interface to support multiple 
 * underlying forms. This allows multiple types of objects to be passed to a
 * single method
 * 
 * 
 * */
interface LivesInOcean {
	public void makeSound();
}
class Dolphin implements LivesInOcean {
	public void makeSound() {
		System.out.println("whistle");
	}
}
class Whale implements LivesInOcean {
	public void makeSound() {
		System.out.println("sing");
	}
}

public class MethodUse {
	//checkSound() can take any object whose class implements LivesInOcean
	private void checkSound(LivesInOcean animal) {
		animal.makeSound();
	}
	public static void main(String[] args) {
		MethodUse mu = new MethodUse();
		mu.checkSound(new Dolphin());
		mu.checkSound(new Whale());
	}

}
