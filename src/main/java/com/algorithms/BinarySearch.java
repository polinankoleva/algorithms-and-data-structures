package com.algorithms;

/**
 * Util class for different functions which contain binary search algorithm.
 * 
 * @author Polina Koleva
 *
 */
public class BinarySearch {

	/**
	 * Do a binary search for a particular number. Time complexity O(log n)
	 * 
	 * @param array
	 * @param start the index from which it has to start searching
	 * @param end the index from which it has to end searching.
	 * @param number number it is searched for
	 * @return true if the number was found; otherwise false
	 */
	public static boolean bs(int[] array, int start, int end, int number) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (number < array[middle]) {
				return bs(array, start, middle - 1, number);
			} else if (number > array[middle]) {
				return bs(array, middle + 1, end, number);
				// the number is found
			} else {
				return true;
			}
		}
		// the number is not found
		return false;
	}
}
