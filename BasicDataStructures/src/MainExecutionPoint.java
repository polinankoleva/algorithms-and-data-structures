/**
 * This code is produced with learning purposes.
 * 
 * Polina Koleva, 02.08.2016.
 */

import com.data.structutes.simple.stack.StackArray;

/**
 * Main class which is used for testing the implemented data structures.
 * 
 * @author Polina Koleva
 *
 */
public class MainExecutionPoint {

	public static void main(String[] args) {
		
		// Static stack testing ...
		StackArray stack = new StackArray(5);
		
		System.out.println("Push 1...");
		stack.push(1);
		int result = stack.pop();
		System.out.println("Pop... Result:" + result);
		
		result = stack.pop();
		System.out.println("Pop empty stack... Result:" + result);
		
		System.out.println("Is stack empty:" + stack.isEmpty());
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		// Overflow...
		stack.push(6);
		
		System.out.println("Is stack empty:" + stack.isEmpty());
		
		System.out.println("Pop.... Result:" + stack.pop());
		System.out.println("Pop... Result:" + stack.pop());
		System.out.println("Pop... result:" + stack.pop());
		System.out.println("And so on...");
	}

}
