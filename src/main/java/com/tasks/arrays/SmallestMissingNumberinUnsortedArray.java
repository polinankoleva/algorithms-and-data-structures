package com.tasks.arrays;

/**
 * Given an array of integers, find the first missing positive integer in linear
 * time and constant space. In other words, find the lowest positive integer
 * that does not exist in the array. The array can contain duplicates and
 * negative numbers as well.
 * 
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0]
 * should give 3.
 * 
 * @author Polina Koleva
 *
 */
public class SmallestMissingNumberinUnsortedArray {

	// only positive number, greater than 0
	public static int smallestMissingNumber(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int current = Math.abs(arr[i]);
			if (current - 1 < arr.length && arr[current - 1] > 0) {
				arr[current - 1] = -arr[current - 1];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				return i + 1;
			}
		}
		return arr.length + 1;
	}

	// positive and negative numbers + 0
	public static int smallestMissingNumber2(int[] arr) {
		// shift negative number and zero to the left of the array
		int nextPositiveIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 0 && i == nextPositiveIndex) {
				nextPositiveIndex++;
			} else if (arr[i] <= 0 && nextPositiveIndex < i) {
				// swap negative and positive
				int temp = arr[i];
				arr[i] = arr[nextPositiveIndex];
				arr[nextPositiveIndex] = temp;
				nextPositiveIndex++;
			}
		}
		for (int i = nextPositiveIndex; i < arr.length; i++) {
			int current = Math.abs(arr[i]);
			if (current + nextPositiveIndex - 1 < arr.length
					&& arr[current + nextPositiveIndex - 1] > 0) {
				arr[current + nextPositiveIndex - 1] = -arr[current + nextPositiveIndex - 1];
			}
		}
		int j = 1;
		for (int i = nextPositiveIndex; i < arr.length; i++) {
			if (arr[i] > 0) {
				return j;
			}
			j++;
		}
		return arr.length + 1;
	}

	public static void main(String[] arr) {
		 System.out.println(smallestMissingNumber2(new int[] { 1, 2, 6, 9 }));
		 System.out.println(smallestMissingNumber2(new int[] { 4, 5, 10, 11 }));
		 System.out.println(smallestMissingNumber2(new int[] { 1, 2, 3 }));
		 System.out.println(smallestMissingNumber2(new int[] { 1, 2, 3, 4, 5, 6, 7, 10
		 }));
		System.out.println(smallestMissingNumber2(new int[] { -1, 4, 3, 1 }));
		System.out.println(smallestMissingNumber2(new int[] { -1, -2, -3, 4, 6, -5, -6 }));
		System.out.println(smallestMissingNumber2(new int[] { 1, 2, -3, 4, 6, -5, -6 }));

	}
}
