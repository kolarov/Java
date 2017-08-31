package io.serialization;

import java.io.*;
import java.util.*;

/* 
 * ObjectOutputStream: writeObject(Object obj) -> serialization
 * ObjectInputStream:  readObject()			   -> deserialize 
 * 					   (needs an explicit cast at runtime) 
 * 
 * */

public class ObjectStream {
	
	//deserialize
	public static List<SerializableAnimal> getAnimals(File data) throws 
										IOException, ClassNotFoundException {
		List<SerializableAnimal> animals = new ArrayList<>();
		try(ObjectInputStream in = new ObjectInputStream(
										new BufferedInputStream(
											new FileInputStream(data))))
		{
			while(true) {
				Object object = in.readObject(); //throws ClassNotFoundException
				if(object instanceof SerializableAnimal) //check for null values
					animals.add((SerializableAnimal) object); //cast needed
			}
		} catch (EOFException e) { //proper way to find when finished 
			 // swallow the exception
		}
		return animals;
	}
	
	//serialize
	public static void createAnimalsFile (List<SerializableAnimal> animals, 
												File data) throws IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(
										new BufferedOutputStream(
											new FileOutputStream(data))))
		{
			for(SerializableAnimal animal : animals)
				out.writeObject(animal);
		}
	}
	
	public static void main(String[] args) throws IOException, 
													ClassNotFoundException {
		List<SerializableAnimal> animals = new ArrayList<>();
		animals.add(new SerializableAnimal("Tommy Tiger", 5, 'T'));
		animals.add(new SerializableAnimal("Peter Penguin", 8, 'P'));
		
		File dataFile = new File("src\\io\\serialization\\animal.data");
		createAnimalsFile(animals, dataFile);
		System.out.println(getAnimals(dataFile));
		
		
		//PrintStream and PrintWriter do not throw any checked exceptions
		try(PrintWriter out = 
				new PrintWriter("src\\io\\serialization\\zoo.log");)
		{
			out.print(5);  						//PrintWriter method
			out.write(String.valueOf(5));   	//Writer method
			out.print(2.0);  					//PrintWriter method
			out.write(String.valueOf(2.0)); 	//Writer method
			SerializableAnimal pig = new SerializableAnimal("Piggy", 5, 'P');
			out.print(pig);  					//PrintWriter method
			out.write(pig == null ? "null" : pig.toString());  //Writer method
					
		}
		
		
		

	}

}
