package com.tasks.arrays;

import java.util.HashMap;

/**
 * Given an unsorted array of integers, find a subarray which adds to a given
 * number. If they are more than one subarrays with sum as the given number,
 * print any of them.
 * 
 * @author Polina Koleva
 *
 */
public class SubarrayWithGivenSum {

	// Complexity O(n), negative and positive numbers
	public static void subArraySum(int sum, int[] arr) {
		HashMap<Integer, Integer> sums = new HashMap<>();
		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (currSum == sum) {
				System.out.println("Sum found. Starting at index " + 0 + " till index " + i);
				return;
			} else {
				int difference = currSum - sum;
				if (sums.containsKey(difference)) {
					System.out.println("Sum found. Starting at index " + (sums.get(difference) + 1) + " till index " + i);
				}
			}
			sums.put(currSum, i);
		}
		// if no sum found
		System.out.println("No sum found in the array");
	}

	public static void main(String[] args) {
		subArraySum(33, new int[] { 1, 4, 20, 3, 10, 5 });
		subArraySum(-10, new int[] { 10, 2, -2, -20, 10 });
		subArraySum(20, new int[] { 10, 0, 2, -2, -20, 10 });
	}
}
