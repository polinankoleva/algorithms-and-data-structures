/**
 * This code is produced with learning purposes.
 * 
 * Polina Koleva, 02.08.2016
 */
package com.data.structures.simple;
import java.util.Stack;

/**
 * A queue ADS implemented using two dymanic stacks.
 * 
 * @author Polina Koleva
 *
 */
public class DynamicTwoStacksQueue<Integer> {

	Stack<Integer> stack1;
	Stack<Integer> stack2;

	/**
	 * Constructor.
	 */
	public DynamicTwoStacksQueue() {
		this.stack1 = new Stack<Integer>();
		this.stack2 = new Stack<Integer>();
	}

	public Integer peek() {
		if (!stack2.isEmpty()) {
			return stack2.peek();
		} else {
			// remove all elements from stack 1, insert them into stack 2
			// except the last one
			while (stack1.size() > 1) {
				stack2.push(stack1.pop());
			}
			Integer toReturn = stack1.pop();
			// move the last element to stack 2
			stack2.push(toReturn);
			return toReturn;
		}
	}

	public void enqueue(Integer number) {
		stack1.push(number);
	}

	public Integer dequeue() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		} else {
			// remove all elements from stack 1, insert them into stack 2,
			// and return the last element in stack1
			while (stack1.size() > 1) {
				stack2.push(stack1.pop());
			}
			return stack1.pop();
		}
	}

	/**
	 * If both stacks are empty.
	 * 
	 * @return true if both stacks are empty, otherwise false
	 */
	public boolean isEmpty() {
		// if both top indexes are out of range
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * If the first stack is empty.
	 * 
	 * @return true if the first stack is empty, otherwise false
	 */
	public boolean isStack1Empty() {
		if (stack1.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * If the second stack is empty.
	 * 
	 * @return true if the second stack is empty, otherwise false
	 */
	public boolean isStack2Empty() {
		if (stack2.isEmpty()) {
			return true;
		}
		return false;
	}
}
