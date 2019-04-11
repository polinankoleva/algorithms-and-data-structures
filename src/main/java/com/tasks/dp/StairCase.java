package com.tasks.dp;

/**
 * There exists a staircase with N steps, and you can climb up either 1 or 2
 * steps at a time. Given N, write a function that returns the number of unique
 * ways you can climb the staircase. The order of the steps matters.
 * 
 * For example, if N is 4, then there are 5 unique way
 * 
 * @author Polina Koleva
 *
 */
public class StairCase {
	// recursive solution
	public static int numWays(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			return numWays(n - 1) + numWays(n - 2);
	}

	// DP solution, bottop up approach
	public static long numWaysDP(int n) {
		long[] memoizatoionArray = new long[n + 1];
		// add base cases
		memoizatoionArray[0] = 1L;
		memoizatoionArray[1] = 1L;
		for (int i = 2; i <= n; i++) {
			memoizatoionArray[i] = memoizatoionArray[i - 1] + memoizatoionArray[i - 2];
		}
		return memoizatoionArray[n];
	}

	// recursive solution
	public static int numWays(int n, int[] elements) {
		if (n == 0)
			return 1;
		int value = 0;
		// for all element greater smaller than n
		for (int i = 0; i < elements.length; i++) {
			if (n - elements[i] >= 0) {
				value = value + numWays(n - elements[i], elements);
			}
		}
		return value;
	}

	// DP solution, bottop up approach
	public static long numWaysDP(int n, int[] elements) {
		long[] memoizatoionArray = new long[n + 1];
		// add base cases
		memoizatoionArray[0] = 1;
		for (int i = 2; i <= n; i++) {
			long value = 0L;
			for (int j = 0; j < elements.length; j++) {
				if (i - elements[j] >= 0) {
					value = value + memoizatoionArray[i - elements[j]];
				}
			}
			memoizatoionArray[i] = value;
		}
		return memoizatoionArray[n];
	}

	public static void main(String[] args) {
		System.out.println(numWaysDP(0, new int[] { 1, 3, 5 }));
		System.out.println(numWaysDP(1, new int[] { 1, 3, 5 }));
		System.out.println(numWaysDP(2, new int[] { 1, 3, 5 }));
		System.out.println(numWaysDP(3, new int[] { 1, 3, 5 }));
		System.out.println(numWaysDP(4, new int[] { 1, 3, 5 }));
		System.out.println(numWaysDP(5, new int[] { 1, 3, 5 }));
		System.out.println(numWaysDP(10, new int[] { 1, 3, 5 }));
		System.out.println(numWaysDP(20, new int[] { 1, 3, 5 }));
		System.out.println(numWaysDP(30, new int[] { 1, 3, 5 }));
		System.out.println(numWaysDP(40, new int[] { 1, 3, 5 }));

	}
}
