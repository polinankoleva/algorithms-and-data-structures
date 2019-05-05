package com.tasks.arrays;

/**
 * Write a program which takes as input an array of D and updates the array to
 * represent digits encoding a decimal number the number D + 1. For example, if
 * the input is (1,2,9) then you should update the array to (1,3,0). Your
 * algorithm should work even if it is implemented in a language that has
 * finite-precision arithmetic. Task 6.2, EPI book.
 * 
 * @author Polina Koleva
 *
 */
public class ArbitraryPrecisionInteger {

	public static int[] increase(int[] number) {
		// add one to the last digit
		number[number.length - 1] += 1;
		// carry the additional sum
		for (int i = number.length - 1; i > 0; i--) {
			int currentNumber = number[i];
			if (currentNumber >= 10) {
				number[i] = currentNumber % 10;
				number[i - 1] += currentNumber / 10;
			} else {
				break;
			}
		}
		// check first digit
		if (number[0] >= 10) {
			// copy array and add one digit more
			int[] result = new int[number.length + 1];
			result[0] = number[0] / 10;
			result[1] = number[0] % 10;
			for (int i = 2; i < result.length; i++) {
				result[i] = number[i - 1];
			}
			return result;
		}
		return number;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 8 };
		int[] result = increase(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
