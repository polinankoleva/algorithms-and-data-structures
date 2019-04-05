package com.tasks.dp;

/**
 * Write a recursive function to multiply tow positive integers without using
 * the * operator. You can use addition, subtraction, and bit shifting, but you
 * should minimize the number of those operations.
 * 
 * @author Polina Koleva
 *
 */
public class RecursiveMultiply {

	public static int multiply(int n1, int n2) {
		if (n1 >= n2) {
			return helperMultiply(n1, n2);
		} else {
			return helperMultiply(n2, n1);
		}
	}

	public static int helperMultiply(int number, int times) {
		if (times == 0)
			return 0;
		if (times == 1)
			return number;
		else
			return helperMultiply(number, times - 1) + number;
	}

	public static int multiplySimpler(int n1, int n2) {
		if (n1 == 0 || n2 == 0)
			return 0;
		int bigger = n1 >= n2 ? n1 : n2;
		int smaller = n1 >= n1 ? n2 : n1;
		return miltiplyHelperSimpler(smaller, bigger);
	}

	public static int miltiplyHelperSimpler(int smaller, int bigger) {
		if (smaller == 1)
			return bigger;
		int smallerDivision = smaller / 2;
		int side1 = miltiplyHelperSimpler(smallerDivision, bigger);
		return smaller % 2 == 0 ? side1 + side1 : side1 + side1 + bigger;
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		multiply(1000000000, 1000);
		long endTime = System.nanoTime();

		// get difference of two nanoTime values
		long timeElapsed = endTime - startTime;

		System.out.println(timeElapsed);
		startTime = System.nanoTime();
		multiplySimpler(100000000, 100000);
		endTime = System.nanoTime();

		// get difference of two nanoTime values
		timeElapsed = endTime - startTime;
		System.out.println(timeElapsed);
	}

}
