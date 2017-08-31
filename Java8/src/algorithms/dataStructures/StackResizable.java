package algorithms.dataStructures;


import java.util.Iterator;

//Generic Stack implementation based on a dynamic array
public class StackResizable<E> implements Iterable<E>
{	
	//Variables:
	private E[] a = (E[]) new Object[1]; 	// stack items
	private int N = 0;                   	// number of items
	
	
	//Methods
	public boolean isEmpty()  
	{  
		return N == 0; 
	}
	
	public int size() 
	{  
		return N;      
	}
	
	private void resize(int max) 		// move stack to a new array of size max
	{ 
		E[] temp = (E[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		System.out.println("Stack's new capacity is " + max);
	    a = temp;
	}
	
	public void push(E element) 		// Add item to top of stack.
	{ 
		if (N == a.length) 
			resize(2*a.length);
	   	a[N++] = element;
	}
	
	public E pop() 						// Remove item from top of stack.
	{	
		E element = a[--N];
		a[N] = null;  
		if (N > 0 && N == a.length/4) 
			resize(a.length/2);
		return element;
	}
	
	//Iterator:
	public Iterator<E> iterator() 
	{  
		return new ReverseIterator();  
	}
	
	private class ReverseIterator implements Iterator<E> // LIFO iteration
	{  
	    private int i = N;
	    
	    public boolean hasNext() 
	    {  
	    	return i > 0;   
	    }
	    
	    public E next()  
	    {  
	    	return a[--i];  
	    }
	    
	    public void  remove() {}
	}
	

}
