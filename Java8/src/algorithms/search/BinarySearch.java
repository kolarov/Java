package algorithms.search;

import java.util.*;
import java.io.*;
import java.nio.file.*;


// This program am takes the name of a file (a sequence of integers) as argument 
// and filters any entry that is on the file from standard input, leaving only 
// integers that are not in the file on standard output.

// The search() method is am implementation of binary search 
// from JavaRepo\Java8\src run:
// java algorithms.search.BinarySearch Filter.txt < algorithms\search\Input.txt

public class BinarySearch 
{
	
	// Gives the index position of a value in a List or -1 if not found
	public static int search(int value, List<Integer> list) 
	{  
		int lo  = 0;
		int hi = list.size() - 1;
		while (lo <= hi)
		{  
			int mid = lo + (hi - lo) / 2;
	     
			if (value < list.get(mid)) 
				hi = mid - 1;
			else if (value > list.get(mid)) 
				lo = mid + 1;
			else                   
				return mid;
		}
		return -1; // not in the list
	} 
	
	public static void main(String[] args) throws IOException
	{     
	    // Get the filter file with a relative Path 
	    Path p = Paths.get("algorithms\\search\\" + args[0]);
	    List<Integer> list = new ArrayList<>();
	    Files.lines(p)
	    	 .mapToInt(i -> Integer.parseInt(i)) 			  
	    	 .forEach(i -> list.add(i));
	    Collections.sort(list);
	 
	    Scanner sc = new Scanner(System.in); //Get input from the from System.in
	    while (sc.hasNextInt())
	    { 
	    	int key = sc.nextInt();
			if (search(key, list) < 0) // print if key is not in whitelist.
				System.out.println(key);
		}
	    sc.close();
	}

}
