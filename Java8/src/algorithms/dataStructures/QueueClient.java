package algorithms.dataStructures;

import java.util.Scanner;

public class QueueClient 
{

	public static void main(String[] args) 
	{
		
		QueueLinkedList<String> queue = new QueueLinkedList<>();
		
		Scanner sc = new Scanner(System.in); //Get input from the from System.in
		while (sc.hasNext())
		{
			String element = sc.next();
			if (!element.equals("-"))
				queue.enqueue(element);
			else if (!queue.isEmpty())
				System.out.print(queue.dequeue() + " ");
		}
		System.out.println("First on the queue: " + queue.dequeue());
		System.out.println("(" + queue.size() + " elements left on the queue)");
	}

}
