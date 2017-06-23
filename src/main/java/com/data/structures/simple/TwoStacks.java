/**
 * This code is produced with learning purposes.
 * 
 * Polina Koleva, 02.08.2016
 */
package com.data.structures.two.stacks;

/**
 * Class that represents implementation of two stacks storing their element in
 * one array. One of the stacks start filling the array from its 0 index, the
 * other one from its last index. If no space is left in the array, both stacks
 * are full.
 * 
 * @author Polina Koleva
 *
 */
public class TwoStacks {

	// keeps index to the top element of the first stack
	int stack1TopIndex;
	// keeps index to the top element of the second stack
	int stack2TopIndex;
	// array that stores the stacks
	int[] stacks;

	/**
	 * Constructor.
	 * 
	 * @param totalStacksSize
	 *            total number of elements that both stacks can store.
	 */
	public TwoStacks(int totalStacksSize) {
		this.stacks = new int[totalStacksSize];
		this.stack1TopIndex = -1;
		this.stack2TopIndex = this.stacks.length;
	}

	/**
	 * Add an element to one of the stacks.
	 * 
	 * @param stackNumber
	 *            1 for the first stack, 2 for the second
	 * @param element
	 *            element that is inserted
	 */
	public void push(int stackNumber, int element) {
		if (stackNumber == 1) {
			if (isFull()) {
				System.out.println("Overflows...");
				return;
			} else {
				// changed the index to the next cell
				// where a new element is inserted
				stack1TopIndex++;
				this.stacks[stack1TopIndex] = element;
			}
		} else if (stackNumber == 2) {
			if (isFull()) {
				System.out.println("Overflows...");
				return;
			} else {
				// changed the index to the previous cell
				// where a new element is inserted
				stack2TopIndex--;
				this.stacks[stack2TopIndex] = element;
			}
		}
	}

	/**
	 * Pops an element from one of the stacks.
	 * 
	 * @param stackNumber
	 *            1 for the first stack, 2 for the second
	 * @return
	 */
	public int pop(int stackNumber) {
		if (stackNumber == 1) {
			if (isStack1Empty()) {
				System.out.println("Underflows...");
				return Integer.MIN_VALUE;
			} else {
				// decrease the top index, because an element
				// is removed/returned
				stack1TopIndex--;
				return stacks[stack1TopIndex + 1];
			}
		} else if (stackNumber == 2) {
			if (isStack2Empty()) {
				System.out.println("Underflows...");
				return Integer.MIN_VALUE;
			} else {
				stack2TopIndex++;
				return stacks[stack2TopIndex - 1];
			}
		}
		// this shouldn't be reached
		return Integer.MIN_VALUE;
	}

	/**
	 * If both stacks are empty.
	 * 
	 * @return true if both stacks are empty, otherwise false
	 */
	public boolean isEmpty() {
		// if both top indexes are out of range
		if (stack1TopIndex == -1 && stack2TopIndex == this.stacks.length) {
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
		if (stack1TopIndex == -1) {
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
		if (stack2TopIndex == this.stacks.length) {
			return true;
		}
		return false;
	}

	/**
	 * If both stacks in total have the maximum number of elements.
	 * 
	 * @return
	 */
	public boolean isFull() {
		if (stack1TopIndex == stack2TopIndex - 1) {
			return true;
		}
		return false;
	}
}
