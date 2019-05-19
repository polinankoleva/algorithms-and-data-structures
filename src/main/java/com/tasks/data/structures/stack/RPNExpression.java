package com.tasks.data.structures.stack;

import java.util.Stack;

/**
 * Write a program that takes an arithmetical expression in RPN and returns the
 * number that the expression evaluates to. Task 9.2, EPI book
 * 
 * @author Polina Koleva
 *
 */
public class RPNExpression {

	// O(n) time complexity, O(n/2) space complexity
	public static int evaluate(String RPN) {
		String[] arr = RPN.split(",");
		Stack<Integer> result = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			String current = arr[i];
			if (isOperation(current)) {
				int a = result.pop();
				int b = result.pop();
				result.push(calculate(a, b, current));
			} else {
				// parse to int and add to the stack
				int currentInt = Integer.parseInt(current);
				result.push(currentInt);
			}
		}
		return result.pop();
	}

	public static boolean isOperation(String op) {
		if (op.equals("+") || op.equals("-") || op.equals("x") || op.equals("/"))
			return true;
		return false;
	}

	// linear space, linear time, not correct
	public static void evaluateRecursively(String[] arr, int startIndex) {
		if (startIndex + 1 >= arr.length)
			return;
		int a = Integer.parseInt(arr[startIndex]);
		int b = Integer.parseInt(arr[startIndex + 1]);
		String operation = arr[startIndex + 2];
		arr[startIndex + 2] = String.valueOf(calculate(a, b, operation));
		evaluateRecursively(arr, startIndex + 2);
	}

	public static int calculate(int a, int b, String operation) {
		if (operation.equals("+")) {
			return a + b;
		} else if (operation.equals("-")) {
			return a - b;
		} else if (operation.equals("x")) {
			return a * b;
		} else if (operation.equals("/")) {
			return a / b;
		}
		return a + b;
	}

	public static void main(String[] args) {
		// result 15
		System.out.println(evaluate("3,4,+,2,x,1,+"));
		// result 31
		System.out.println(evaluate("3,4,+,4,+,4,+,2,x,1,+"));

	}

}
