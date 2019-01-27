package com.tasks.arrays;

/**
 * Given a sorted array of n distinct integers where each integer is in the
 * range of 0 to m-1 and m is greater than n. Find the smallest number that is
 * missing from the array.
 * 
 * @author Polina Koleva
 *
 */
public class SmallestMissingNumberinSortedArray {

	public static int smallestMissingNumber(int[] array) {
		if (array[0] != 0) {
			return 0;
		}
		for (int i = 0; i < array.length - 1; i++) {
			if (Math.abs(array[i] - array[i + 1]) > 1) {
				return array[i] + 1;
			}
		}
		return array[array.length - 1] + 1;
	}

	public static void main(String[] arr) {
		System.out.println(smallestMissingNumber(new int[] { 0, 1, 2, 6, 9 }));
		System.out.println(smallestMissingNumber(new int[] { 4, 5, 10, 11 }));
		System.out.println(smallestMissingNumber(new int[] { 0, 1, 2, 3 }));
		System.out.println(smallestMissingNumber(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 10 }));
	}
}
