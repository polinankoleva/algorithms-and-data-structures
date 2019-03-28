package com.tasks.arrays;

import java.util.HashMap;

/**
 * Given an array of integers, find length of the largest subarray with sum
 * equals to 0.
 * 
 * @author Polina
 *
 */
public class SubarrayWithSumZero {

	// Complexity O(n), negative and positive numbers
	public static int subArraySumZero(int[] arr) {
		HashMap<Integer, Integer> sums = new HashMap<>();
		int maxLenght = 0;
		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (currSum == 0) {
				System.out.println("Array with sum 0 found. Its lenght is " + (i + 1));
				if (i + 1 > maxLenght) {
					maxLenght = i + 1;
				}
			} else if (sums.containsKey(currSum)) {

				System.out.println("Array with sum 0 found. Its lenght is " + (i - sums.get(currSum)));
				if (i - sums.get(currSum) > maxLenght) {
					maxLenght = i - sums.get(currSum);
				}
			} else if (arr[i] != 0) {
				sums.put(currSum, i);
			}
		}
		return maxLenght;
	}

	public static void main(String[] args) {
		System.out.println(subArraySumZero(new int[] { 1, 4, 20, 3, 10, 5 }));
		System.out.println(subArraySumZero(new int[] { 10, 2, -2, -20, 10 }));
		System.out.println(subArraySumZero(new int[] { 10, 0, 2, -2, -20, 10 }));
		System.out.println(subArraySumZero(new int[] { 10, 0, 2, -2, 10, 10 }));
		System.out.println(subArraySumZero(new int[] { 15, -2, 2, -8, 1, 7, 10, 23 }));
		System.out.println(subArraySumZero(new int[] { 0, 0, 7, 0, 0 }));
	}
}
