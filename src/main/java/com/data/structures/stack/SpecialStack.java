package com.data.structures.stack;

import java.util.Stack;

/**
 * Design a Data Structure SpecialStack that supports all the stack operations
 * like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
 * which should return minimum element from the SpecialStack. All these
 * operations of SpecialStack must be O(1). To implement SpecialStack, you
 * should only use standard Stack data structure and no other data structure
 * like arrays
 * 
 * @author Polina Koleva
 *
 * @param <Integer>
 */
public class SpecialStack<Integer> {

	Stack<Integer> normalStack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public void push(Integer value) {
		normalStack.push(value);
		if (minStack.isEmpty()) {
			minStack.push(value);
		} else {
			Integer minValue = minStack.peek();
			if ((int) minValue > (int) value) {
				minStack.push(value);
			}
		}
	}

	public Integer pop() {
		Integer value = normalStack.pop();
		Integer minValue = minStack.peek();
		if (minValue == value) {
			minStack.pop();
		}
		return value;
	}

	public Integer getMin() {
		return minStack.peek();
	}
}
