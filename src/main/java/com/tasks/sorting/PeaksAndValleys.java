package com.tasks.sorting;

/**
 * Peaks and Valleys: In an array of integers, a "peak" is an element which is
 * greater than or equal to the adjacent integers and a "valley" is an element
 * which is less than or equal to the adjacent integers. For example, in the
 * array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. Given
 * an array of integers, sort the array into an alternating sequence of peaks
 * and valleys. EXAMPLE Input: {5, 3, 1, 2, 3} Output: {5, 1, 3, 2, 3}
 * 
 * @author Polina Koleva
 *
 */
public class PeaksAndValleys {
	public static void peaksAndValleys(int[] arr) {
		boolean isPeak = false;
		if (arr.length <= 1)
			return;
		// first element is valley, second element needs to be peak
		if (arr[0] <= arr[1])
			isPeak = true;
		for (int i = 1; i < arr.length - 1; i++) {
			int current = arr[i];
			int next = arr[i + 1];
			if (isPeak) {
				if (current < next) {
					// exchange current and next and continue
					arr[i] = next;
					arr[i + 1] = current;
					// next element needs to be a valley
				}
				isPeak = false;
			} else {
				if (current > next) {
					// exchange current and next and continue
					arr[i] = next;
					arr[i + 1] = current;
					// next element needs to be a peak
				}
				isPeak = true;
			}
		}
	}

	public static void main(String[] args) {
		int[] result = new int[] { 5, 8, 6, 2, 3, 4, 6 };
		peaksAndValleys(result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		result = new int[] { 9, 1, 0, 4, 8, 7};
		peaksAndValleys(result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
