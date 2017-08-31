package io.classes;

import java.io.*;
import java.util.*;

/* Instead of immediately copying the data we read from the file into the output 
 * file, we store it in a List of strings.This allows us to both display and 
 * modify the data, prior to writing it to disk.
 * 
 * */

public class CopyTextFile {
	
	public static List<String> readFile(File source) throws IOException {
		List<String> data = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(source)))
		{
			String s;
			while ( (s = reader.readLine()) != null)
				data.add(s);
			return data;
		}
	}
	
	public static void writeFile(List<String> data, File destination) throws
																IOException {
		try (BufferedWriter writer = new BufferedWriter(
											new FileWriter(destination)))
		{
			for (String s : data) {
				writer.write(s);
				writer.newLine();
			}		
		}
	}
		
	public static void main(String[] args) throws IOException {
		File source = new File("src\\io\\file\\sample.txt");
		File destination = new File("src\\io\\file\\copy.txt"); 
		List<String> data = readFile(source);
		for(String record : data)
			System.out.println(record);
		writeFile(data, destination);
	}

}
