package collections.searchingAndSorting.comparator;

import java.util.*;

public class Duck implements Comparable<Duck>{
	private String name;
	private int weight;
	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Duck d) {     //delegates to String's compareTo()
		return name.compareTo(d.name);
	}
	
	@Override
	public String toString() {
		return "Duck [name=" + name + ", weight=" + weight + "]";
	}

	

}