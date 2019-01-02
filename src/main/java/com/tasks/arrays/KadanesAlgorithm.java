package com.tasks.arrays;

/**
 * Find the contiguous subarray within a one-dimensional array of
 * numbers(positive and negative) which has the largest sum.
 * 
 * @author Polina Koleva
 *
 */
public class KadanesAlgorithm {

	public static int maxSubarrray(int[] array) {
		int maxEndingHere = array[0]; // local maximum
		int maxSoFar = array[0]; // global maximum
		for (int i = 1; i < array.length; i++) {
			maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		System.out.println(maxSubarrray(new int[] { 1, 2, 3 }));
		System.out.println(maxSubarrray(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }));
		System.out.println(maxSubarrray(new int[] { -1, -2, -3 }));
	}
}
