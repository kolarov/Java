package collections.collection.queue;

/* _____ Queue interface _____
 * Use a queue when elements are added and removed in a specific order. It is
 * typically used for sorting elements prior to processing them. Assumed to be 
 * FIFO. All queues have specific requirements for adding and removing the next 
 * element.
 * 
 * 
 * boolean 		offer 		(Object element)
 * Object 		remove		() Retrieves and removes the head 
 * Object 		poll		() Retrieves and removes the head, or returns null
 * Object 		element		() Retrieves, but does not remove, the head
 * Object 		peek		() Retrieves, but does not remove, the head or 
 * 							   returns null
 * 
 * FIFO (single-ended queue) => offer/poll/peek
 * LIFO (stack)				 => push/pop/peek
 *  
 */


/* _____Methods of Deque interface_____
 * A Deque is a linear collection that supports element insertion and removal at
 * both ends. It extends Queue and adds many new methods. The following are the
 * most important ones. They are essential for stack implementation.
 * 
 * void 		push 		(Object element) 
 * Object 		pop 		() Retrieves and removes the head 
 * 
 *  
 */

import java.util.*;

public class QueueExample1 {

	public static void main(String[] args) {
		
		//_____ Implementations _____
		
		/* LinkedList implements both List and Queue interfaces. 
		 * It is less efficient than a pure queue.
  		 * 
  		 * offer:		O(1)
  		 * peek:		O(1)
  		 * poll:		O(1)  
  		 * size:		O(1)  
  		 * 
  		 */
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(10);			//true    [10]   		
		queue.offer(4);				//true    [10, 4]
		queue.peek();				//10      [10, 4]
		System.out.println(queue);  //10      [14]
		queue.poll();               //4
		System.out.println(queue.poll());
		queue.peek();               //null
		
		
		/* ArrayDeque implements both List and Queue interfaces. 
		 * It is less efficient than a pure queue.
  		 * 
  		 * offer:		O(1)
  		 * peek:		O(1)
  		 * poll:		O(1)  
  		 * size:		O(1)  
  		 * 
  		 */
		System.out.println();
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(10); //     [10]
		stack.push(4);  //     [4, 10]
		stack.peek();   //4    [4, 10]
		System.out.println(stack);
		stack.pop();    //4    [10]
		System.out.println(stack);
		stack.pop();    //10   []
		stack.peek();   //null    
		System.out.println(stack);

		
		
		
		
	}

}
