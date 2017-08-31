package algorithms.sort;

import java.util.*;
import java.math.*;

public class SortAlgos extends SortBase {
	
	
	
	//Selection sort ___________________________________________________________
	public static void selectionSort(Comparable[] a)
	{
		int N = a.length;
		for(int i = 0; i < N; i++)
		{
			int min = i;
			for(int j = i+1; j <N;j++)
				if(less(a[j], a[min])) min=j;
			exch(a, i, min);
		}
	}
	
	//Quick sort _______________________________________________________________
	public static void quickSort(Comparable[] a)
	{ 
		shuffle(a);         
		// Eliminate dependence on input.
		sort(a, 0, a.length - 1);
	}
	
	// Partition into a[lo..i-1], a[i], a[i+1..hi].
	private static int partition(Comparable[] a, int lo, int hi)
	{  
		int i = lo, j = hi+1;            // left and right scan indices
		Comparable v = a[lo];            // partitioning item
	  	while (true)
	  	{  // Scan right, scan left, check for scan complete, and exchange.
	  		while (less(a[++i], v)) if (i == hi) break;
	  		while (less(v, a[--j])) if (j == lo) break;
	  		if (i >= j) break;
	  		exch(a, i, j);
	  	}
	  	exch(a, lo, j);      
	  	// Put v = a[j] into position
	  	return j;             // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo) return;
	    	int j = partition(a, lo, hi); 
	    sort(a, lo, j-1);              // Sort a[lo .. j-1].
	    sort(a, j+1, hi);              // Sort a[j+1 .. hi].
	}
	
	
	//UTILITY METHODS___________________________________________________________
	public static void shuffle(Object[] a) {
		
		if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int)(Math.random()*(n-1-i));     // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
	

	
}
