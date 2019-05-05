package com.tasks.arrays;

/**
 * Write a program that takes two arrays representing integers, and returns
 * their product as an array. For example, if the inputs are (1,9, 3, 7, 0,7, 7,
 * 2,1} and (-7,6, 1,8, 3, 8, 2, 5, 7, 2, 8, 7), your function should return
 * (-1, 4, 7, 5, 7, 3, 9, 5, 2, 5, 8, 9, 6, 7, 6, 4, 1, 2, 9, 2, 7). Task 6.3,
 * EPI book
 * 
 * @author Polina Koleva
 *
 */
public class MultiplyArbitraryPrecisionInt {

	public static int[] multiply(int[] number, int[] multiplier) {
		int[] result = null;
		boolean hasMinus = false;
		// handle minus sign
		if (number[0] < 0) {
			hasMinus = true;
			number[0] *= -1;
		}
		if (multiplier[0] < 0) {
			multiplier[0] *= -1;
			if (hasMinus) {
				hasMinus = false;
			} else {
				hasMinus = true;
			}
		}
		for (int i = multiplier.length - 1; i >= 0; i--) {
			int[] multiplied = multiply(number, multiplier[i]);
			multiplied = addZeros(multiplied, multiplier.length - 1 - i);
			if (result == null) {
				result = multiplied;
			} else {
				result = sum(result, multiplied);
			}
		}
		if (hasMinus) {
			result[0] *= -1;
		}
		return result;
	}

	public static int[] multiply(int[] number, int multiplier) {
		int[] result = new int[number.length];
		for (int i = number.length - 1; i > 0; i--) {
			int multiplication = number[i] * multiplier;
			multiplication += result[i];
			if (multiplication >= 10) {
				result[i] = multiplication % 10;
				result[i - 1] += multiplication / 10;
			} else {
				result[i] = multiplication;
			}
		}
		int multiplication = number[0] * multiplier;
		multiplication += result[0];
		if (multiplication >= 10) {
			// copy array and add one digit more
			int[] resultCopy = new int[result.length + 1];
			resultCopy[0] = multiplication / 10;
			resultCopy[1] = multiplication % 10;
			for (int i = 2; i < resultCopy.length; i++) {
				resultCopy[i] = result[i - 1];
			}
			return resultCopy;
		} else {
			result[0] = multiplication;
		}
		return result;
	}

	public static int[] addZeros(int[] number, int zeros) {
		if (zeros == 0)
			return number;
		int[] result = new int[number.length + zeros];
		for (int i = 0; i < number.length; i++) {
			result[i] = number[i];
		}
		for (int i = number.length; i < number.length + zeros; i++) {
			result[i] = 0;
		}
		return result;
	}

	public static int[] sum(int[] numberOne, int[] numberTwo) {
		int[] result;
		int longerIndex;
		int[] longerArr;
		int shorterIndex;
		int[] shorterArr;
		if (numberOne.length > numberTwo.length) {
			longerArr = numberOne;
			longerIndex = numberOne.length - 1;
			result = new int[longerIndex + 1];
			shorterArr = numberTwo;
			shorterIndex = numberTwo.length - 1;
		} else {
			longerArr = numberTwo;
			longerIndex = numberTwo.length - 1;
			result = new int[longerArr.length];
			shorterArr = numberOne;
			shorterIndex = numberOne.length - 1;
		}
		while (shorterIndex >= 0) {
			int sum = longerArr[longerIndex] + shorterArr[shorterIndex];
			if (sum >= 10) {
				result[longerIndex] = sum % 10;
				int left = sum / 10;
				if (longerIndex == 0) {
					// numbers are equal size
					// copy array and add one digit more
					int[] resultCopy = new int[result.length + 1];
					resultCopy[0] = sum / 10;
					resultCopy[1] = sum % 10;
					for (int i = 2; i < resultCopy.length; i++) {
						resultCopy[i] = result[i - 1];
					}
					return resultCopy;
				} else {
					longerArr[longerIndex - 1] += left;
				}
			} else {
				result[longerIndex] = sum;
			}
			longerIndex--;
			shorterIndex--;
		}
		while (longerIndex >= 0) {
			if (longerIndex == 0) {
				if (longerArr[0] >= 10) {
					// copy array and add one digit more
					int[] resultCopy = new int[result.length + 1];
					resultCopy[0] = longerArr[0] / 10;
					resultCopy[1] = longerArr[0] % 10;
					for (int i = 2; i < resultCopy.length; i++) {
						resultCopy[i] = result[i - 1];
					}
					return resultCopy;
				} else {
					result[0] = longerArr[0];
				}
			} else {
				if (longerArr[longerIndex] >= 10) {
					result[longerIndex] = longerArr[longerIndex] % 10;
					int left = longerArr[longerIndex] / 10;
					longerArr[longerIndex - 1] += left;
				} else {
					result[longerIndex] = longerArr[longerIndex];
				}
			}
			longerIndex--;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] result = multiply(new int[] { 1, 9, 3, 7, 0, 7, 7, 2, 1 },
				new int[] { -7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7 });
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
