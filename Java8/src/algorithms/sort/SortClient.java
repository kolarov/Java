package algorithms.sort;

import java.util.*;
import static algorithms.sort.SortAlgos.*;

public class SortClient {
	public static void main(String[] args)
	{ 
		Scanner sc = new Scanner(System.in); //Read strings from standard input
		List<String> list = new ArrayList<>();
		
		while (sc.hasNext())
		{
			list.add(sc.next());
		}
		String[] a = list.toArray(new String[list.size()]);
		
		long startTime = System.nanoTime();
		selectionSort(a);
		long endTime1 = System.nanoTime();
		quickSort(a);
		long endTime2 = System.nanoTime();
		
		assert isSorted(a);
		SortAlgos.show(a);
		System.out.println("selectionSort takes: " + (endTime1-startTime));
		System.out.println("quickSort takes: " + (endTime2-endTime1));
	}
}
