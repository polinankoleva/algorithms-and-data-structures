package com.tasks.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an algorithm to print all valid (e.g., properly opened and closed)
 * combinations of n pairs of parentheses. EXAMPLE:
 * Input: 3 Output : ((() ) ) , (() () ) , (() ) () , () (() ) , () () ()
 * Task 8.9, CCI
 * @author Polina Koleva
 *
 */
public class NPairParentheses {

	public static void parentheses(char[] parentArr, int start, int end, List<String> result) {
		if (start > end) {
			result.add(String.valueOf(parentArr));
			return;
		}
		if (start != end - 1) {
			// first choice
			char[] copySeparate = parentArr.clone();
			copySeparate[start] = '(';
			copySeparate[end] = ')';
			parentheses(copySeparate, start + 1, end - 1, result);
		}
		// second choice
		char[] copyNextToEach = parentArr.clone();
		copyNextToEach[start] = '(';
		copyNextToEach[start + 1] = ')';
		parentheses(copyNextToEach, start + 2, end, result);

	}

	public static void main(String[] args) {
		int pairs = 3;
		char[] parent = new char[pairs * 2];
		List<String> result = new ArrayList<String>();
		parentheses(parent, 0, parent.length - 1, result);
		result.forEach(c -> {
			System.out.println(c.toString());
		});
	}
}
