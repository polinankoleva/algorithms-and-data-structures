package com.algorithms.dp;

/**
 * Calculate Fibonacci numbers.
 * 
 * @author Polina Koleva
 *
 */
public class FibonacciNumber {

	// exponential time using recursion
	public static int fibonacciNumber(int n) {
		int fn = 0;
		if (n <= 2) {
			fn = 1;
		} else {
			fn = fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
		}
		return fn;
	}

	// linear time using dynamic programming
	public static int dpFibonacciNumber(int n) {
		int[] fibNumbers = new int[n];
		for (int i = 0; i < n; i++) {
			if (i <= 1) {
				fibNumbers[i] = 1;
			} else {
				fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
			}
		}
		return fibNumbers[n-1];
	}
}
