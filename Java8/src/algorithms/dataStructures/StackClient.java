package algorithms.dataStructures;

import java.util.Iterator;
import java.util.Scanner;

public class StackClient 
{

	public static void main(String[] args) 
	{
		
		StackFixed<String>		stackF 	= new StackFixed<String>(100);
		StackResizable<String> 	stackR 	= new StackResizable<>();
		StackLinkedList<String> stackL	= new StackLinkedList<>();
		
		Scanner sc = new Scanner(System.in); //Get input from the from System.in
		while (sc.hasNext())
		{
			String element = sc.next();
			if (!element.equals("-"))
				stackL.push(element);
		    else if (!stackL.isEmpty()) 
		    	System.out.print(stackL.pop() + " ");
			System.out.println(stackL.size());
		}
		System.out.println("Last pushed element was: " + stackL.pop());
		System.out.println("(" + stackL.size() + "elements left on stack)");
		
		//This does not work with a StackFixed since arrays are not Iterable
		Iterator<String> i = stackL.iterator();
		while (i.hasNext())
		{	
			System.out.println(i.hasNext());
			i.next();
			stackL.pop();
			System.out.println("Stack's size is " + stackL.size());
		}

	}

}
