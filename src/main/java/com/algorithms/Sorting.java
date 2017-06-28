/**
 * This code is produced with learning purposes.
 * 
 * Polina Koleva, 28.06.2017.
 */
package com.algorithms;

/**
 * Util class for different sorting algorithms.
 * 
 * @author Polina Koleva
 *
 */
public class Sorting {

	// Time complexity O(n^2)
	public static int[] vanillaInsertionSort(int arr[]) {
		// skip the first element
		for (int i = 1; i < arr.length; i++) {
			int d = i;
			while (d > 0 && (arr[d] < arr[d - 1])) {
				int temp = arr[d - 1];
				arr[d - 1] = arr[d];
				arr[d] = temp;
				d--;
			}
		}
		return arr;
	}

	//insertion sort with binary search
	public static int[] bsInsertionSort(int arr[]){
		return null;
	}

	// divide and conquer 
	public static int[] mergeSort(int arr[], int start, int end) {
		// base of the recursion
		if (start == end) {
			return new int[] { arr[start] };
		}
		int middle = (start + end) / 2;
		int[] left = mergeSort(arr, start, middle);
		int[] right = mergeSort(arr, middle + 1, end);
		return merge(left, right);
	}

	/**
	 * Merge two sorted arrays. Time complexity O(n)
	 */
	public static int[] merge(int[] left, int[] right) {
		// first array's index
		int leftIndex = 0;
		// second array's index
		int rightIndex = 0;
		int[] result = new int[left.length + right.length];
		int resultIndex = 0;
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex]) {
				result[resultIndex] = left[leftIndex];
				leftIndex++;
			} else {
				result[resultIndex] = right[rightIndex];
				rightIndex++;
			}
			resultIndex++;
		}
		// copy remaining of the left array
		while (leftIndex < left.length) {
			result[resultIndex] = left[leftIndex];
			leftIndex++;
			resultIndex++;
		}
		// copy remaining of the right array
		while (rightIndex < right.length) {
			result[resultIndex] = right[rightIndex];
			rightIndex++;
			resultIndex++;
		}
		return result;
	}
	
	// best case O(n) when array already sorted
	// worst case O(n^2)
	public static int[] bubbleSort(){
		return null;
	}
	
	//TODO implement
	public static int[] quicksort(){
		return null;
	}
	
	//TODO implement
	public static int[] heapsort(){
		return null;
	}
	
	//TODO implement
	public static int[] selectionsort(){
		return null;
	}
}
