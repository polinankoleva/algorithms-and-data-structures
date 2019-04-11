package com.tasks.dp;

/**
 * Given a boolean expression consisting of the symbols 0 (false), 1 (true), &
 * (AND), I (OR), and /\ (XOR), and a desired boolean result value result,
 * implement a function to count the number of ways of parenthesizing the
 * expression such that it evaluates to result.
 * 
 * @author Polina Koleva
 *
 */
public class BooleanEvaluation {
	public static int evaluateExpression(char[] expr, int start, int end, boolean result) {
		if (start > end)
			return 0;
		if (start == end) {
			boolean localResult = convertToBoolean(expr[start]);
			if (localResult == result) {
				return 1;
			} else {
				return 0;
			}
		}
		int countNoBrackets = evaluateExpression(expr, start + 2, end,
				neededResult(convertToBoolean(expr[0]), expr[1], result));
		int countBrackets = 0;
		if (end - start >= 4) {
			boolean bracketResult = getResult(convertToBoolean(expr[start]), expr[start + 1],
					convertToBoolean(expr[start + 2]));
			boolean neededResult = neededResult(bracketResult, expr[start + 3], result);
			countBrackets = evaluateExpression(expr, start + 4, end, neededResult);
		}
		return countNoBrackets + countBrackets;
	}

	public static boolean neededResult(boolean exp, char op, boolean result) {
		if (result == getResult(exp, op, false)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean convertToBoolean(char c) {
		return c == '1' ? true : false;
	}

	public static boolean getResult(boolean exp1, char op, boolean exp2) {
		if (op == '&') {
			return exp1 & exp2;
		} else if (op == '|') {
			return exp1 | exp2;
		} else if (op == '^') {
			return exp1 ^ exp2;
		}
		return false;
	}

	public static int countEval(String evaluation, boolean result) {
		if (evaluation.isEmpty())
			return 0;
		if (evaluation.length() == 1) {
			boolean localResult = convertToBoolean(evaluation.charAt(0));
			if (localResult == result) {
				return 1;
			} else {
				return 0;
			}
		}
		int ways = 0;
		for (int i = 1; i < evaluation.length() - 1; i = i + 2) {
			String leftSide = evaluation.substring(0, i);
			String rightSide = evaluation.substring(i + 1);
			int leftTrue = countEval(leftSide, true);
			int rightTrue = countEval(rightSide, true);
			int leftFalse = countEval(leftSide, false);
			int rightFalse = countEval(rightSide, false);

			int total = (leftFalse + leftTrue) * (rightFalse + rightTrue);
			char op = evaluation.charAt(i);
			int totalTrue = 0;
			if (op == '&') {
				totalTrue = leftTrue * rightTrue;
			} else if (op == '|') {
				totalTrue = leftTrue * rightFalse + leftTrue * rightTrue + leftFalse * rightTrue;
			} else if (op == '^') {
				totalTrue = leftTrue * rightTrue + leftFalse * rightFalse;
			}
			int subResult = result ? totalTrue : total - totalTrue;
			ways = +subResult;
			System.out.println(ways);
		}
		return ways;
	}

	public static void main(String[] args) {
		String expression = "1^0|0|1";
		// System.out.println(evaluateExpression(expression.toCharArray(), 0,
		// expression.length() - 1, false));
		System.out.println(countEval(expression, false));
		// expression = "0&0&0&1^1";
		// System.out.println(evaluateExpression(expression.toCharArray(), 0,
		// expression.length() - 1, true));
		// System.out.println(countEval(expression, true));
	}
}
