package com.tasks.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of size |n - 1| and it contains numbers only from 1 to n with
 * one element missing. Find the missing number.
 * 
 * @author Polina Koleva
 *
 */
public class MissingNumberInArray {

	public static int missingNumber(int n, int[] array) {
		int totalSum = (n * (n + 1)) / 2;
		for (int i = 0; i < array.length; i++) {
			totalSum -= array[i];
		}
		return totalSum;
	}

	public static int[] missingBinaryNumber(int n, List<int[]> numbers) {
		int[] missingNumber = new int[numbers.get(0).length];
		missingBinaryNumber(n, missingNumber.length - 1, numbers, missingNumber);
		return missingNumber;
	}

	/**
	 * An array A contains all the integers from Oto n, except for one number which
	 * is missing. In this problem, we cannot access an entire integer in A with a
	 * single operation. The elements of A are represented in binary, and the only
	 * operation we can use to access them is "fetch the jth bit of A[ i ],"which
	 * takes constant time. Write code to find the missing integer. Can you do it in
	 * O(n) time?
	 */
	public static void missingBinaryNumber(int n, int index, List<int[]> numbers, int[] missingNumber) {
		if (index < 0)
			return;
		// count number of 0s and number of 1s for index
		int ones = 0;
		int zeros = 0;
		for (int i = 0; i < numbers.size(); i++) {
			int[] current = numbers.get(i);
			if (current[index] == 0) {
				zeros++;
			} else {
				ones++;
			}
		}
		// decide 0 or 1 for result at index index
		if (n % 2 == 0) {
			if (ones > zeros) {
				missingNumber[index] = 0;
			} else {
				missingNumber[index] = 1;
			}
		} else {
			zeros--;
			if (ones > zeros) {
				missingNumber[index] = 0;
			} else {
				missingNumber[index] = 1;
			}
		}
		// rule out inconsistency from the given array
		List<Integer> toRemove = new ArrayList<Integer>();
		for (int i = 0; i < numbers.size(); i++) {
			int[] current = numbers.get(i);
			if (current[index] != missingNumber[index]) {
				toRemove.add(i);
			}
		}
		for (int i = 0; i < toRemove.size(); i++) {
			numbers.remove((int) toRemove.get(i));
		}
		// do the same for the next index
		missingBinaryNumber(n, index - 1, numbers, missingNumber);
	}

	public static void main(String[] args) {
		System.out.println(missingNumber(5, new int[] { 1, 2, 3, 5 }));
		System.out.println(missingNumber(10, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10 }));
		System.out.println(missingNumber(2, new int[] { 1 }));
	}
}
