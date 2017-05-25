/**
 * This code is produced with learning purposes.
 * 
 * Polina Koleva, 02.08.2016
 */
package com.data.structures.simple.stack;

/**
 * Static implementation of a stack using an array.
 * 
 * @author Polina Koleva
 *
 */
public class StaticStack {

	// an index of the element which is added to the stack most recently
	int topIndex;
	// array implementation of a stack
	int[] stack;

	/**
	 * Constructor. Set the static size of a stack.
	 */
	public StaticStack(int stackSize) {
		this.stack = new int[stackSize];
		// when topIndex is -1 - it means no elements in the stack
		topIndex = -1;
	}

	/**
	 * Adds new element to the stack.
	 * 
	 * @param element
	 */
	public void push(int element) {
		if (topIndex + 1 > stack.length - 1) {
			System.out.println("Overflow...");
			return;
		} else {
			topIndex++;
			stack[topIndex] = element;
		}
	}

	/**
	 * Removes the most recently added element.
	 * 
	 * @return
	 */
	public int pop() {
		// if the stack is empty - some meaningless result
		int poppedElement = Integer.MIN_VALUE;
		if (isEmpty()) {
			System.out.println("Underflow...");
		} else {
			poppedElement = stack[topIndex];
			topIndex--;
		}
		return poppedElement;
	}

	/**
	 * Checks if the stack is empty.
	 * 
	 * @return true if a stack is empty; otherwise - false
	 */
	public boolean isEmpty() {
		if (topIndex == -1) {
			return true;
		}
		return false;
	}
}
