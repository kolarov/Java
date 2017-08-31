package io.userInteraction;

import java.io.*;
import java.util.*;

//compile and run from terminal in order to get a console instance 
public class NewWay {

	public static void main(String[] args) throws IOException, 
												  NumberFormatException 
	{
		Console console = System.console();
		if (console == null)
			throw new RuntimeException("Console not available");
		else {
			console.writer().print("How excited are you?");
			//the flush method forces any buffered output to be written 
			//immediately. Call flush() prior to calling any readLine() or
			//readPassword() methods
			console.flush();
			String excitementAnswer = console.readLine();
			String name = console.readLine("Please enter your name: \n ");
			Integer age = 0;
			console.writer().print("What is your age? \n ");
			console.flush();
			BufferedReader reader = new BufferedReader(console.reader());
			String value = reader.readLine();
			age = Integer.valueOf(value);
			console.writer().println();
			console.format("your name is: " + name);
			console.writer().println();
			console.format("\n your age is: " + age);
			console.printf("\n Your excitement level is: " + excitementAnswer);
			
			char[] password = console.readPassword("Enter password: ");
			console.format("Enter your password again: ");
			console.flush();
			char[] verify = console.readPassword();
			boolean match = Arrays.equals(password, verify);
			//Immediately clear password from memory
			for (int i = 0; i < verify.length; i++) 
				password[i] = 'x';
			for (int i = 0; i < verify.length; i++) 
				verify[i] = 'x';
			console.format("\n Password was " + (match ? "correct!":"incorrect!")); 
																
			
			
		}
	}

}
