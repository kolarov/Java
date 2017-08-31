package collections.array;

import java.util.Arrays;

public class ArrayExample1 {

	public static void main(String[] args) {
		//Instantiate
		double[] myArray = {3.4, 1.9, 2.9, 3.5};
		
		//Sort
		Arrays.sort(myArray);
		
		// Print all
		for (int i = 0; i < myArray.length; i++) {
		   System.out.print(myArray[i] + " ");
		}
		System.out.println();
		
		// Multidimensional Array
		String[][] names = { {"Mr. ", "Mrs. ", "Ms. "}, {"Smith", "Jones"} };
        System.out.println(names[0][0] + names[1][0]);
        
		//Search
		System.out.println(Arrays.binarySearch(myArray, 2));   // -2
		System.out.println(Arrays.binarySearch(myArray, 2.9)); //  1
		
		// copyOfRange()
		double[] copyArray = Arrays.copyOfRange(myArray, 2, 9);
		for (int i = 0; i < copyArray.length; i++) {
		   System.out.print(copyArray[i] + " ");
		}
		System.out.println();
		
		// arraycopy()
		char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a'};
        char[] copyTo = new char[7];  // allocates memory for 7 chars

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));
	}

}
