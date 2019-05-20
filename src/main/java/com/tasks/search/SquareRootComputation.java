package com.tasks.search;

/**
 * Write a program which takes a nonnegative integer and returns the largest
 * integer whose square is less than or equal to the given integer. For example,
 * if the input is 16, return 4; if the input is 300, return 17, since 172 = 289
 * < 300 and 182 = 324 > 300. Task 12.4, EI book
 * 
 * @author Polina Koleva
 *
 */
public class SquareRootComputation {

	public static int largestSquare(int number) {
		return largestSquare(number, 0, number) - 1;
	}

	public static int largestSquare(int number, int start, int end) {
		if (start == end)
			return start;
		int middle = start + (end - start) / 2;
		int square = middle * middle;
		if (square == number) {
			return middle;
		} else if (number > square) {
			return largestSquare(number, middle + 1, end);
		} else {
			return largestSquare(number, start, middle - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(largestSquare(300));
		System.out.println(largestSquare(16));
		System.out.println(largestSquare(15));
	}
}
