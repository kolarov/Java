package io.serialization;

import java.io.Serializable;

/*
 * Serializable is a tagging interface that any class can implement
 * It indicates that we have made sure that the classes of all instance variables
 * are also marked Serializable or transient(skipped in serialization)
 * 
 * When we deserialize an object, the constructor of the serialized class is not
 * called. Java calls the first no-argument constructor for the first 
 * non-serializable parent class, skipping the constructors of any serialized 
 * class in between. 
 * 
 * Any static variables or default initializations are ignored. 
 * When we deserialize:
 * - transient variables get default values.
 * - if there was an earlier serialVersionUID where a variable was not static 
 * 	 but now it is, the static variables get last value from when the variable
 * 	 was not static.
 * 
 */
public class SerializableAnimal implements Serializable	{
	
	private String name;
	private transient int age;	
	private char type;
	//private static char type;
	
	@Override
	public String toString() {
		return " \n SerializableAnimal [name=" + name + ", age=" + age + ", type="
				+ type + "]";
	}

	public SerializableAnimal(String name, int age, char type) {
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public char getType() {
		return type;
	}
	
	
	
	
}
