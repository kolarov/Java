package designPrinciples.designPatterns.factory;

public abstract class Food {
	
	private int quantity;
	
	public Food(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public abstract void consumed();		
}

class Hay extends Food {
	
	public Hay(int quantity) {
		super(quantity);
	}
	public void consumed() {
		System.out.println("Hay eaten: " + getQuantity());
	};		
}

class Pallets extends Hay {
	
	public Pallets(int quantity) {
		super(quantity);
	}
	public void consumed() {
		System.out.println("Pallets eaten: " + getQuantity());
	};		
}

class Fish extends Food {
	
	public Fish(int quantity) {
		super(quantity);
	}
	public void consumed() {
		System.out.println("Fish eaten: " + getQuantity());
	};		
}