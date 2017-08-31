package algorithms.dataStructures;

//Generic Stack implementation based on an array
public class StackFixed<E> 
{
	
	//Variables:
   	private E[] arr;   		// stack entries
   	private int N;      	// size
   	
   	//Constructor:
   	public StackFixed(int capacity) 
   	{ 
	   	arr = (E[]) new Object[capacity];  // generic array creation is not allowed 
   	}
   	
   	//Methods:
   	public boolean isEmpty() 		//is the stack empty?
   	{  	
	   	return N == 0; 
   	}
   	
   	public int size() 				//number of elements in the stack
   	{  			
	   	return N; 
   	}
   	
   	public void push(E element) 	//add an item
   	{   
   		arr[N++] = element; 
   	}
   	
   	public E pop() 					//remove the most recently added item
   	{  			
	   	return arr[--N]; 
   	}
	       
	
}
