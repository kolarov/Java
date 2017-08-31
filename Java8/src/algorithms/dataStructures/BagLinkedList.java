package algorithms.dataStructures;

import java.util.Iterator;

//A bag is a collection that does not support removing items 
public class BagLinkedList<E> implements Iterable<E> 
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
	
	public void add(E element)
	{
		Node oldFirst = first;
		first = new Node();
		first.value = element;
		first.next = oldFirst;
	   	N++;
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
