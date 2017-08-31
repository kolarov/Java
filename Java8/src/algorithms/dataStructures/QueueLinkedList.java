package algorithms.dataStructures;

import java.util.Iterator;

//Generic Queue implementation based on a linked-list 
public class QueueLinkedList<E> implements Iterable<E> 
{
	
	//Variables:
	private Node first; // oldest node
	private Node last; 	// most recently added node	
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
	
	public void enqueue(E element)
	{
		Node oldLast = last;
		last = new Node();
		last.value = element;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldLast.next = last;
		N++;
	}
	
	public E dequeue()
	{
		E element = first.value;
		first = first.next;
		if (isEmpty())
			last = null;
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
