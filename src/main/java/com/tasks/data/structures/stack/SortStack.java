package com.tasks.data.structures.stack;

import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements
 * into any other data structure (such as an array). The stack supports the f o
 * llowing operations: push, pop, peek, and is Empty. CCI book, Task 3.5.
 * 
 * @author Polina Koleva
 *
 */
public class SortStack {
	// return pointer to the secondary stack
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> addStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			Integer current = stack.pop();
			if (addStack.isEmpty()) {
				addStack.push(current);
				continue;
			}

			if (addStack.peek() >= current) {
				addStack.push(current);
			} else {
				int i = 0;
				// find place where to insert current
				while (!addStack.isEmpty() && addStack.peek() < current) {
					stack.push(addStack.pop());
					i++;
				}
				addStack.push(current);

				// return the elements from addStack we pushed to stack
				while (i > 0) {
					addStack.push(stack.pop());
					i--;
				}
			}

		}
		return addStack;
	}

	public static void sortStackVoid(Stack<Integer> stack) {
		Stack<Integer> addStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			Integer current = stack.pop();
			if (addStack.isEmpty()) {
				addStack.push(current);
				continue;
			}
			// find place where to insert the element in addStack
			// keep addStack in DESC order
			if (current >= addStack.peek()) {
				addStack.push(current);
			} else {
				int i = 0;
				while (!addStack.isEmpty() && addStack.peek() > current) {
					stack.push(addStack.pop());
					i++;
				}
				addStack.push(current);
				// move back elements from stack to addStack
				while (i > 0) {
					addStack.push(stack.pop());
					i--;
				}
			}
		}

		while (!addStack.isEmpty()) {
			stack.push(addStack.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(16);
		stack.push(14);
		stack.push(1);
		stack.push(11);
		stack.push(35);
		stack.push(4);
		sortStackVoid(stack);
		stack.forEach(v -> {
			System.out.print(v + " ");
		});
	}
}
