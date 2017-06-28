package com.algorithms;

import java.util.Arrays;

/**
 * Util class for different versions for peak search algorithm.
 * 
 * @author Polina Koleva
 *
 */
public class PeakSearch {

	/**
	 * 1D peak search. Find the peak and return it if exists. array[i] is a peak
	 * if array[i] >= array[i+1] and array[i] >= array[i-1]. If i == 0, then
	 * array[i] has to be >= only to array[i+1]. If i == n - 1, then array[i] >=
	 * only to array[i-1].
	 * 
	 * @param array
	 *            n>=2
	 * @return -1 if no peak exists
	 */
	// divide & conquer approach
	public static int recursiveFindPeakCopy(int[] array) {
		// base case
		if (array.length == 1) {
			return array[0];
		}
		if (array.length == 2) {
			if (array[0] > array[1]) {
				return array[0];
			} else {
				return array[1];
			}
		}
		int middleIndex = array.length / 2;
		if (array[middleIndex] < array[middleIndex - 1]) {
			return recursiveFindPeakCopy(Arrays.copyOfRange(array, 0, middleIndex));
		} else if (array[middleIndex] < array[middleIndex + 1]) {
			return recursiveFindPeakCopy(Arrays.copyOfRange(array, middleIndex + 1, array.length));
		} else {
			return array[middleIndex];
		}
	}

	public static int recursiveFindPeak(int[] array, int start, int end) {
		// base case
		if ((end - start) == 0) {
			return array[end];
		}
		// two elements only
		if ((end - start - 1) == 0) {
			if(array[start] >= array[end]){
				return array[start];
			} else {
				return array[end];
			}
		}
		int middle = (end + start) / 2;
		if (array[middle] < array[middle - 1]) {
			return recursiveFindPeak(array, 0, middle);
		}
		if (array[middle] < array[middle + 1]) {
			return recursiveFindPeak(array, middle + 1, array.length - 1);
		}
		return array[middle];
	}

	// Time complexity O(n)
	public static int simpleFindPeak(int[] array) {
		// edge cases
		if (array[0] >= array[1]) {
			return array[0];
		}
		if (array[array.length - 1] >= array[array.length - 2]) {
			return array[array.length - 1];
		}
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i] >= array[i - 1] && array[i] >= array[i + 1]) {
				return array[i];
			}
		}
		return -1;
	}

	/**
	 * 2D peak search.
	 * 
	 * @param array
	 * @return
	 */
	public static int findPeak(int[][] array) {
		//TODO implement this
		return 0;

	}
}
