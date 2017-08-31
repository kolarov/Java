package algorithms.dataStructures;

import java.util.Iterator;


// Generic Stack implementation based on a linked-list 
public class StackLinkedList<E> implements Iterable<E> 
{
	
	//Variables:
	private Node first; // top of stack (most recently added node)
	private int N;      // number of items
	
	//Node inner class:
	private  class Node 
	{  
		E value;
		Node next;
	}
	
	//Methods:
	public boolean isEmpty() 
	{  
		return N == 0; 
	} 
	
	public int size()        
	{  
		return N; 
	}
	
	public void push(E element) 		// Add item to top of stack.
	{ 
		Node oldTop = first;
		first = new Node();
		first.value = element;
		first.next = oldTop;
	   	N++;
	}
	
	public E pop() 						// Remove item from top of stack.
	{	
		E element = first.value;
		first = first.next;
		N--;
		return element;
	}
	
	// Iterator:
	public Iterator<E> iterator() 
	{  
		return new ListIterator();  
	}
	
	private class ListIterator implements Iterator<E> 
	{  
		private Node current = first;
		
	    public boolean hasNext() 
	    {  
	    	return current != null;   		
	    }
	    
	    public E next()  
	    {   
	    	E element = current.value;
	    	current = current.next;
	    	return element;
	    }
	    public void remove() {}
	}

}
