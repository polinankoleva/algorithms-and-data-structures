package com.tasks.data.structures.stack;

import java.util.Stack;
/**
 * Task 9.3, EPI book
 * @author Polina Koleva
 *
 */
public class ParenthesisCorrectness {

	public static boolean checkParentesis(String expr) {
		char[] exprArr = expr.toCharArray();
		Stack<Character> opening = new Stack<Character>();
		for (int i = 0; i < exprArr.length; i++) {
			char current = exprArr[i];
			if(isOpening(current)) {
				opening.push(current);
			} else {
				char openingBracket = opening.pop();
				if(!doesMatch(openingBracket, current)) {
					return false;
				}
			}
		}
		return opening.isEmpty();
	}

	public static boolean isOpening(char s) {
		if (s == '(' || s == '[' || s == '{')
			return true;
		return false;
	}

	public static boolean doesMatch(char open, char close) {
		switch (open) {
		case '{':
			if (close == '}')
				return true;
		case '(':
			if (close == ')')
				return true;
		case '[':
			if (close == ']')
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// expected true
		System.out.println(checkParentesis(""));
		// expected true
		System.out.println(checkParentesis("[()[]()()]"));
		// expected true
		System.out.println(checkParentesis("([]){()}"));
		// expected false
		System.out.println(checkParentesis("[()[]{()()"));
	}
}
