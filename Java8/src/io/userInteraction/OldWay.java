package io.userInteraction;

import java.io.*;

public class OldWay {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
									new InputStreamReader(System.in));
		String userInput = reader.readLine();
		System.out.println("You entered: " + userInput);
	}

}
